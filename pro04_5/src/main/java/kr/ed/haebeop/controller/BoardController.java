package kr.ed.haebeop.controller;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.service.BoardService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.List;

@Controller
@RequestMapping("/board/*")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("list.do")  //
    public String getBoardList(@RequestParam("curpage") int curpage, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Board> boardList = boardService.getBoardList1(page.getOffset(), page.getSize());
        int total = boardService.totalCount();
        page.ComputePage(total);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @PostMapping("list2.do")  //
    public String getBoardList2(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Board> boardList = boardService.getBoardList2(page.getOffset(), page.getSize(), field, query);
        int total = boardService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("list2.do")  //
    public String getBoardList3(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Board> boardList = boardService.getBoardList2(page.getOffset(), page.getSize(), field, query);
        int total = boardService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }

    @GetMapping("get.do")
    public String getBoard(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Cookie[] cookieFromRequest = request.getCookies();
        String cookieValue = null;
        for(int i = 0 ; i<cookieFromRequest.length; i++) {
            // 요청정보로부터 쿠키를 가져온다.
            cookieValue = cookieFromRequest[0].getValue();	// 테스트라서 추가 데이터나 보안사항은 고려하지 않으므로 1번째 쿠키만 가져옴
        }
        // 쿠키 세션 입력
        if (session.getAttribute(bno+":cookie") == null) {
            session.setAttribute(bno+":cookie", bno + ":" + cookieValue);
        } else {
            session.setAttribute(bno+":cookie ex", session.getAttribute(bno+":cookie"));
            if (!session.getAttribute(bno+":cookie").equals(bno + ":" + cookieValue)) {
                session.setAttribute(bno+":cookie", bno + ":" + cookieValue);
            }
        }

        // 쿠키와 세션이 없는 경우 조회수 카운트
        if (!session.getAttribute(bno+":cookie").equals(session.getAttribute(bno+":cookie ex"))) {
            boardService.updateVisitedCount(bno);
            // 가시적으로  조회수 1 추가해줌  board.setVisited(board.getVisited() + 1);
        }

        Board board = boardService.getBoard(bno);

        model.addAttribute("board", board);
        return "/board/get";
    }

    @GetMapping("update.do")
    public String boardUpdateForm(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        Board board = boardService.getBoard(bno);
        model.addAttribute("board", board);
        return "/board/updateForm";
    }

    @PostMapping("update.do")
    public String boardUpdatePro(Board board, HttpServletRequest request, Model model){
        boardService.boardUpDate(board);
        return "redirect:list.do?curpage=1";
    }

    @GetMapping("insert.do")
    public String insertForm(Model model){
        return "/board/insertForm";
    }

    @PostMapping("insert.do")
    public String boardInsertPro(Board board, Model model){
        boardService.boardInsert(board);
        return "redirect:list.do?curpage=1";
    }

    @GetMapping("delete.do")
    public String boardDelete(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        boardService.boardDelete(bno);
        return "redirect:list.do?curpage=1";
    }
}
