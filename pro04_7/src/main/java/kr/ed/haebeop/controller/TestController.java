package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.Test;
import kr.ed.haebeop.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/test/")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("getTestList")
    public String getTestList(Model model) {
        List<Test> testList = testService.getTestList();
        model.addAttribute("testList", testList);
        return "/test/getTestList";
    }

    @GetMapping("getTestList2")
    public String getTestList2(Model model) {
        List<Test> testList = testService.getTestList2();
        model.addAttribute("testList", testList);
        return "/test/getTestList";
    }

    @GetMapping("getTestList3")
    public String getTestList3(Model model) {
        List<Test> testList = testService.getTestList3();
        model.addAttribute("testList", testList);
        return "/test/getTestList";
    }

    //ModelAndView로 리턴하여 진행하는 경우
    //ModelAndView mav = new ModelAndView("/test/getTestList");
    //mav.addObject("testList", testList);
    //return mav;
}
