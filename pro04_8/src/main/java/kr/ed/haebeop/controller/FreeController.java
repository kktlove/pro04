package kr.ed.haebeop.controller;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.Free;
import kr.ed.haebeop.service.BoardService;
import kr.ed.haebeop.service.FreeService;
import kr.ed.haebeop.util.BadWordFilter;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/free/*")
public class FreeController {

    @Autowired
    private FreeService freeService;

    @GetMapping("list.do")  //
    public String getFreeList(@RequestParam("curpage") int curpage, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Free> freeList = freeService.getFreeList1(page.getOffset(), page.getSize());
        int total = freeService.totalCount();
        page.ComputePage(total);
        model.addAttribute("page", page);
        model.addAttribute("freeList", freeList);
        return "/free/list";
    }

    @PostMapping("list2.do")  //
    public String getFreeList2(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Free> freeList = freeService.getFreeList2(page.getOffset(), page.getSize(), field, query);
        int total = freeService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("freeList", freeList);
        return "/free/list";
    }

    @GetMapping("list2.do")  //
    public String getFreeList3(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Free> freeList = freeService.getFreeList2(page.getOffset(), page.getSize(), field, query);
        int total = freeService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("freeList", freeList);
        return "/free/list";
    }

    @GetMapping("get.do")
    public String getFree(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Cookie[] cookieFromRequest = request.getCookies();
        String cookieValue = null;
        for(int i = 0 ; i<cookieFromRequest.length; i++) {
            // 요청정보로부터 쿠키를 가져온다.
            cookieValue = cookieFromRequest[0].getValue();	// 테스트라서 추가 데이터나 보안사항은 고려하지 않으므로 1번째 쿠키만 가져옴
        }
        // 쿠키 세션 입력
        if (session.getAttribute(bno+":cookie2") == null) {
            session.setAttribute(bno+":cookie2", bno + ":" + cookieValue);
        } else {
            session.setAttribute(bno+":cookie2 ex", session.getAttribute(bno+":cookie2"));
            if (!session.getAttribute(bno+":cookie2").equals(bno + ":" + cookieValue)) {
                session.setAttribute(bno+":cookie2", bno + ":" + cookieValue);
            }
        }

        // 쿠키와 세션이 없는 경우 조회수 카운트
        if (!session.getAttribute(bno+":cookie2").equals(session.getAttribute(bno+":cookie2 ex"))) {
            freeService.updateVisitedCount(bno);
            // 가시적으로  조회수 1 추가해줌  board.setVisited(board.getVisited() + 1);
        }

        Free free = freeService.getFree(bno);

        model.addAttribute("free", free);
        return "/free/get";
    }

    @GetMapping("recUpdate.do")
    public String recUpdate(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        Cookie[] cookieFromRequest = request.getCookies();
        String cookieValue = null;
        for(int i = 0 ; i<cookieFromRequest.length; i++) {
            // 요청정보로부터 쿠키를 가져온다.
            cookieValue = cookieFromRequest[0].getValue();	// 테스트라서 추가 데이터나 보안사항은 고려하지 않으므로 1번째 쿠키만 가져옴
        }
        // 쿠키 세션 입력
        if (session.getAttribute(bno+":cookie3") == null) {
            session.setAttribute(bno+":cookie3", bno + ":" + cookieValue);
        } else {
            session.setAttribute(bno+":cookie3 ex", session.getAttribute(bno+":cookie3"));
            if (!session.getAttribute(bno+":cookie3").equals(bno + ":" + cookieValue)) {
                session.setAttribute(bno+":cookie3", bno + ":" + cookieValue);
            }
        }

        // 쿠키와 세션이 없는 경우 조회수 카운트
        if (!session.getAttribute(bno+":cookie3").equals(session.getAttribute(bno+":cookie3 ex"))) {
            freeService.updateRecCount(bno);
            // 가시적으로  조회수 1 추가해줌  board.setVisited(board.getVisited() + 1);
        }
        Free free = freeService.getFree(bno);

        model.addAttribute("free", free);
        return "/free/get";
    }

    @GetMapping("update.do")
    public String freeUpdateForm(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        Free free = freeService.getFree(bno);
        model.addAttribute("free", free);
        return "/free/updateForm";
    }

    @PostMapping("update.do")
    public String freeUpdatePro(Free free, HttpServletRequest request, RedirectAttributes rttr, Model model){
        String word = free.getContent();
        String word2 = free.getTitle();
        BadWordFilter filter = new BadWordFilter();
        Boolean pass = filter.check(word);
        Boolean pass2 = filter.check(word2);
        String msg = "";
        if(pass) {
            msg = filter.messagePrint(word);
            rttr.addFlashAttribute("msg", msg);
            return "redirect:" + request.getHeader("Referer");
        } else if(pass2){
            msg = filter.messagePrint(word2);
            rttr.addFlashAttribute("msg", msg);
            return "redirect:" + request.getHeader("Referer");
        } else {
            freeService.freeUpDate(free);
            return "redirect:list.do?curpage=1";
        }
    }

    @GetMapping("insert.do")
    public String insertForm(Model model){
        return "/free/insertForm";
    }

    @PostMapping("insert.do")
    public String freeInsertPro(Free free, HttpServletRequest request, RedirectAttributes rttr, Model model){
        String word = free.getContent();
        String word2 = free.getTitle();
        BadWordFilter filter = new BadWordFilter();
        Boolean pass = filter.check(word);
        Boolean pass2 = filter.check(word2);
        String msg = "";
        if(pass) {
            msg = filter.messagePrint(word);
            rttr.addFlashAttribute("msg", msg);
            return "redirect:" + request.getHeader("Referer");
        } else if(pass2){
            msg = filter.messagePrint(word2);
            rttr.addFlashAttribute("msg", msg);
            return "redirect:" + request.getHeader("Referer");
        } else {
            freeService.freeInsert(free);
            return "redirect:list.do?curpage=1";
        }
    }

    @GetMapping("delete.do")
    public String freeDelete(@RequestParam("bno") int bno, HttpServletRequest request,Model model){
        freeService.freeDelete(bno);
        return "redirect:list.do?curpage=1";
    }

}
