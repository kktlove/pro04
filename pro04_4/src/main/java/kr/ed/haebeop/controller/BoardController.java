package kr.ed.haebeop.controller;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.service.BoardService;
import kr.ed.haebeop.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
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
        model.addAttribute("boardList", boardList);
        return "/board/list";
    }
}
