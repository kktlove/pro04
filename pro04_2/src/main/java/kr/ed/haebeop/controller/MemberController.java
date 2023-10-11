package kr.ed.haebeop.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

import kr.ed.haebeop.domain.Member;
import kr.ed.haebeop.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    HttpSession session;

    BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();

    /* 관리자가 볼 수 있는 회원목록 */
    @RequestMapping(value="list.do", method = RequestMethod.GET)
    public String memberList(Model model) throws Exception {
        List<Member> memberList = memberService.memberList();
        model.addAttribute("memberList", memberList);
        model.addAttribute("title", "회원 목록");
        return "/member/memberList";
    }

    /* 관리자가 회원의 상세 정보 보기 */
    @GetMapping("detail.do")
    public String memberDetail(@RequestParam String id, Model model) throws Exception {
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "/member/memberDetail";
    }
    // 일반 회원 본인 정보 보기
    @GetMapping("mypage.do")
    public String mypage(Model model) throws Exception {
        String id = (String) session.getAttribute("sid");
        Member member = memberService.getMember(id);
        model.addAttribute("member", member);
        return "/member/mypage";
    }

    //회원 가입 - 약관 동의 페이지 로딩
    @GetMapping("term.do")
    public String getAgree(Model model) throws Exception {
        return "/member/agree";
    }
    //회원 가입 - 회원가입폼 페이지 로딩
    @GetMapping("join.do")
    public String getJoin(Model model) throws Exception {
        return "/member/memberInsert";
    }
    //회원 가입 - Ajax로 아이디 중복 체크
    @RequestMapping(value="idCheck.do", method=RequestMethod.POST)
    public void idCheck(HttpServletResponse response, HttpServletRequest request, Model model) throws Exception {
        String id = request.getParameter("id");
        Member mem = memberService.getMember(id);
        boolean result = false;
        if(mem!=null){
            result = false;
        } else {
            result = true;
        }
        JSONObject json = new JSONObject();
        json.put("result", result);
        PrintWriter out = response.getWriter();
        out.println(json.toString());
    }

    //회원 가입 - 회원 가입 처리
    @RequestMapping(value="insert.do", method = RequestMethod.POST)
    public String memberWrite(Member member, Model model) throws Exception {
        String ppw = member.getPw();
        String pw = pwEncoder.encode(ppw);
        member.setPw(pw);
        memberService.memberInsert(member);
        return "redirect:/";
    }

    //로그인 폼 로딩
    @RequestMapping("login.do")
    public String memberLoginForm(Model model) throws Exception {
        return "/member/loginForm";
    }

    //로그인을 컨트롤러에서 처리
    @PostMapping("signin.do")
    public String memberSignIn(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        Member mem = memberService.signIn(id);
        if(mem!=null){
            boolean loginSuccess = pwEncoder.matches(pw, mem.getPw());
            if(loginSuccess){
                session.setAttribute("member", mem);
                session.setAttribute("sid", id);
                return "redirect:/";
            } else {
                return "redirect:login.do";
            }
        } else {
            return "redirect:login.do";
        }
    }
    //서비스에서 로그인 로직 처리
    @RequestMapping(value = "loginpro.do", method = RequestMethod.POST)
    public String memberLogin(@RequestParam String id, @RequestParam String pw, Model model) throws Exception {
        boolean ps = memberService.loginCheck(id, pw);
        if(ps){
            session.setAttribute("sid", id);
            return "redirect:/";
        } else {
            return "redirect:login.do";
        }
    }
    //로그아웃
    @GetMapping("logout.do")
    public String memberLogout(HttpSession session) throws Exception {
        session.invalidate();
        return "redirect:/";
    }
    //회원정보 변경
    @RequestMapping(value="update.do", method=RequestMethod.POST)
    public String memberUpdate(Member mem, Model model) throws Exception {
        String pwd = "";
        if(mem.getPw().length()<=16) {
            pwd = pwEncoder.encode(mem.getPw());
            mem.setPw(pwd);
        }
        memberService.memberEdit(mem);
        return "redirect:/";
    }
    //회원 탈퇴
    @RequestMapping(value="delete.do", method = RequestMethod.GET)
    public String memberDelete(@RequestParam String id, Model model, HttpSession session) throws Exception {
        memberService.memberDelete(id);
        session.invalidate();
        return "redirect:/";
    }
    //Ajax를 이용하는 로그인 방법
    @RequestMapping(value="loginCheck.do", method = RequestMethod.POST)
    public String memberLoginCtrl(@RequestParam String id, @RequestParam String pw, HttpServletRequest request, RedirectAttributes rttr) throws Exception {
        //session.getAttribute("member");
        Member mdto = new Member();
        mdto.setId(id);
        mdto.setPw(pw);
        Member member = memberService.loginAjax(mdto);
        boolean mat = pwEncoder.matches(mdto.getPw(), member.getPw());
        if(member!=null && mat) {
            session.setAttribute("member", member);
            session.setAttribute("sid", member.getId());
            rttr.addFlashAttribute("msg", "로그인 성공");
            String referer = request.getHeader("Referer");
            return "redirect:"+referer;
            //return "redirect:/";
        } else {
            session.setAttribute("member", null);
            rttr.addFlashAttribute("msg", "로그인 실패");
            return "redirect:loginForm.do";
        }
    }
}
