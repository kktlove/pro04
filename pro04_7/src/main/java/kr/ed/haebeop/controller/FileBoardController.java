package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.AttachVO;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.FileBoard;
import kr.ed.haebeop.service.FileBoardService;
import kr.ed.haebeop.util.Page;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Log4j
@Controller
@RequestMapping("/fileboard/*")
public class FileBoardController {

    @Autowired
    private FileBoardService fileBoardService;

    @GetMapping("/write.do")
    public String write(Model model) {
        return "/fileupload/fileBoardWrite";
    }

    // 주글쓰기 처리
    @PostMapping("/write.do")
    public String write(FileBoard boardVO, String pageNum, HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> files) throws Exception {

        log.info("files 매개변수 : " + files);
        if (files != null) {
            log.info("업로드한 첨부파일 개수 : " + files.size());
        }

        // IP주소 값 저장
        boardVO.setIp(request.getRemoteAddr());

        // insert할 글번호 가져오기
        int num = fileBoardService.nextBoardNum();

        boardVO.setNum(num);
        boardVO.setReadcount(0);

        boardVO.setReRef(num); // 주글일 경우 [글그룹번호]는 글번호와 동일함
        boardVO.setReLev(0);  // 주글일 경우 [들여쓰기 레벨]은 0
        boardVO.setReSeq(0);  // 주글일 경우 [글그룹 안에서의 순서]는 0


        //=========== 파일 업로드 작업 시작 ==============

        ServletContext application = request.getSession().getServletContext();
        String path = "/resources/upload";
        String realPath = application.getRealPath(path);
        log.info("realPath : " + realPath);

        List<AttachVO> attachList = new ArrayList<>();

        // 폴더 동적 생성하기 /resources/upload/2023/10/19
        String uuid_str = getDateFolder();
        File uploadPath = new File(realPath, uuid_str);

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        for (MultipartFile multipartFile : files) {
            AttachVO vo = new AttachVO();
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            String filetype = uploadFilename.substring(uploadFilename.lastIndexOf('.')+1);
            UUID uuid = UUID.randomUUID();
            uploadFilename = uuid.toString() + "_" + uploadFilename;

            vo.setUuid(uuid_str);
            vo.setFilename(uploadFilename);
            vo.setUploadpath(path);
            vo.setFiletype(filetype);
            vo.setBno(boardVO.getNum());
            // 파일 업로드 수행
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
            attachList.add(vo);
        } // for

        //=========== 파일 업로드 작업 끝 ==============

        // 주글을 테이블에 insert하기
        fileBoardService.register(boardVO);
        fileBoardService.registerAttaches(boardVO, attachList);

        // 리다이렉트 시 서버로 다시 전달할 데이터를 저장하기
        //rttr.addAttribute("num", boardVO.getNum());
        //rttr.addAttribute("pageNum", pageNum);

        return "redirect:list.do?curpage=1";
    } // write post

    private String getDateFolder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String str = sdf.format(date);
        return str;
    }

    @GetMapping("list.do")  //
    public String getBoardList(@RequestParam("curpage") int curpage, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<FileBoard> boardList = fileBoardService.getBoardList1(page.getOffset(), page.getSize());
        int total = fileBoardService.totalCount();
        page.ComputePage(total);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/fileupload/list";
    }

    @PostMapping("list2.do")  //
    public String getBoardList2(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<FileBoard> boardList = fileBoardService.getBoardList2(page.getOffset(), page.getSize(), field, query);
        int total = fileBoardService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/fileupload/list";
    }

    @GetMapping("list2.do")  //
    public String getBoardList3(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<FileBoard> boardList = fileBoardService.getFileBoardList2(page.getOffset(), page.getSize(), field, query);
        int total = fileBoardService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/fileupload/list";
    }

    @GetMapping("get.do")
    public String getBoard(@RequestParam("num") int num, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Cookie[] cookieFromRequest = request.getCookies();
        String cookieValue = null;
        for(int i = 0 ; i<cookieFromRequest.length; i++) {
            // 요청정보로부터 쿠키를 가져온다.
            cookieValue = cookieFromRequest[0].getValue();	// 테스트라서 추가 데이터나 보안사항은 고려하지 않으므로 1번째 쿠키만 가져옴
        }
        // 쿠키 세션 입력
        if (session.getAttribute(num+":cookie") == null) {
            session.setAttribute(num+":cookie", num + ":" + cookieValue);
        } else {
            session.setAttribute(num+":cookie ex", session.getAttribute(num+":cookie"));
            if (!session.getAttribute(num+":cookie").equals(num + ":" + cookieValue)) {
                session.setAttribute(num+":cookie", num + ":" + cookieValue);
            }
        }

        // 쿠키와 세션이 없는 경우 조회수 카운트
        if (!session.getAttribute(num+":cookie").equals(session.getAttribute(num+":cookie ex"))) {
            fileBoardService.updateReadCount(num);
            // 가시적으로  조회수 1 추가해줌  board.setVisited(board.getVisited() + 1);
        }

        FileBoard board = fileBoardService.getFileBoard(num);
        List<AttachVO> attachList = fileBoardService.getFileList(num);
        model.addAttribute("board", board);
        model.addAttribute("attachList", attachList);
        return "/fileupload/get";
    }

    @GetMapping("update.do")
    public String boardUpdateForm(@RequestParam("num") int num, HttpServletRequest request,Model model){
        FileBoard board = fileBoardService.getFileBoard(num);
        List<AttachVO> attachList = fileBoardService.getFileList(num);
        model.addAttribute("board", board);
        model.addAttribute("attachList", attachList);
        return "/fileupload/updateForm";
    }

    @PostMapping("update.do")
    public String boardUpdatePro(FileBoard fileBoard, HttpServletRequest request, RedirectAttributes rttr, List<MultipartFile> files, Model model) throws IOException {
        FileBoard boardVO = fileBoard;
        log.info("files 매개변수 : " + files);
        if (files != null) {
            log.info("업로드한 첨부파일 개수 : " + files.size());
        }

        // IP주소 값 저장
        boardVO.setIp(request.getRemoteAddr());

        boardVO.setReadcount(0);

        boardVO.setReRef(0); // 주글일 경우 [글그룹번호]는 글번호와 동일함
        boardVO.setReLev(0);  // 주글일 경우 [들여쓰기 레벨]은 0
        boardVO.setReSeq(0);  // 주글일 경우 [글그룹 안에서의 순서]는 0


        //=========== 파일 업로드 작업 시작 ==============

        ServletContext application = request.getSession().getServletContext();
        String path = "/resources/upload";
        String realPath = application.getRealPath(path);
        log.info("realPath : " + realPath);

        List<AttachVO> attachList = new ArrayList<>();

        // 폴더 동적 생성하기 /resources/upload/2023/10/19
        String uuid_str = getDateFolder();
        File uploadPath = new File(realPath, uuid_str);

        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        for (MultipartFile multipartFile : files) {
            AttachVO vo = new AttachVO();
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            String filetype = uploadFilename.substring(uploadFilename.lastIndexOf('.')+1);
            UUID uuid = UUID.randomUUID();
            uploadFilename = uuid.toString() + "_" + uploadFilename;

            vo.setUuid(uuid_str);
            vo.setFilename(uploadFilename);
            vo.setUploadpath(path);
            vo.setFiletype(filetype);
            vo.setBno(boardVO.getNum());
            // 파일 업로드 수행
            multipartFile.transferTo(new File(uploadPath, uploadFilename));
            attachList.add(vo);
        } // for

        //=========== 파일 업로드 작업 끝 ==============

        // 주글을 테이블에 insert하기
        fileBoardService.updateFileBoard(fileBoard, attachList);
        return "redirect:list.do?curpage=1";
    }

    @GetMapping("delete.do")
    public String boardDelete(@RequestParam("num") int num, HttpServletRequest request,Model model){
        fileBoardService.deleteFileBoard(num);
        return "redirect:list.do?curpage=1";
    }
}
