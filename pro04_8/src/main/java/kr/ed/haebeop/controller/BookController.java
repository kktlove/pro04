package kr.ed.haebeop.controller;

import kr.ed.haebeop.domain.*;
import kr.ed.haebeop.service.BookService;
import kr.ed.haebeop.service.MemberService;
import kr.ed.haebeop.util.Page;
import kr.ed.haebeop.util.Payment;
import kr.ed.haebeop.util.PaymentLoad;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Log4j
@RequestMapping("/book/*")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private MemberService memberService;

    @GetMapping("list.do")
    public String getBookList(@RequestParam("curpage") int curpage, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Book> bookList = bookService.getBookList1(page.getOffset(), page.getSize());
        Integer total = bookService.totalCount();
        page.ComputePage(total);
        model.addAttribute("page", page);
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }


    @PostMapping("list2.do")  //
    public String getBookList2(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Book> bookList = bookService.getBookList2(field, query, page.getOffset(), page.getSize());
        int total = bookService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }

    @GetMapping("list2.do")  //
    public String getBookList3(@RequestParam("curpage") int curpage, @RequestParam("field") String field, @RequestParam("query") String query, Model model){
        Page page = new Page();
        page.generateOffset(curpage, 5);
        List<Book> bookList = bookService.getBookList2(field, query, page.getOffset(), page.getSize());
        int total = bookService.searchCount(field, query);
        page.ComputePage(total);
        model.addAttribute("field", field);
        model.addAttribute("query", query);
        model.addAttribute("page", page);
        model.addAttribute("bookList", bookList);
        return "/book/list";
    }

    @GetMapping("get.do")
    public String getBook(@RequestParam("bookno") int bookno, HttpServletRequest request, Model model){
        Book book = bookService.getBook(bookno);

        /*
        Integer account = bookService.getAmount(book.getBookno());
        if(Objects.nonNull(account)) {
            book.setAmount(account);
        } else {
            book.setAmount(0);
        }
        */
        book.setAmount(bookService.getAmount(bookno));
        model.addAttribute("book", book);
        return "/book/get";
    }


    @GetMapping("/write.do")
    public String write(Model model) {
        return "/book/insertForm";
    }

    @PostMapping("/write.do")
    public String write(Book book, HttpServletRequest request, List<MultipartFile> files) throws Exception {

        log.info("files 매개변수 : " + files);
        if (files != null) {
            log.info("업로드한 첨부파일 개수 : " + files.size());
        }

        ServletContext application = request.getSession().getServletContext();
        String path = "/resources/book/upload";
        String realPath = application.getRealPath(path);
        log.info("realPath : " + realPath);
        File uploadPath = new File(realPath);
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }
        String[] fileName = {"","","",""};
        int cnt = 0;
        for (MultipartFile multipartFile : files) {
            if (multipartFile.isEmpty()) {
                continue;
            }
            String uploadFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(uploadPath, uploadFilename));             // 파일 업로드 수행
            fileName[cnt] = uploadFilename;
            cnt++;
        }
        book.setPfile(fileName[3]);
        book.setBpic(fileName[2]);
        book.setBcover(fileName[1]);
        book.setFcover(fileName[0]);
        bookService.bookInsert(book);
        return "redirect:list.do?curpage=1";
    }

    @GetMapping("addInventory.do")
    public String addInventory(Model model){
        List<Book> bookList = bookService.getBookList();
        Integer total = bookService.totalCount();
        model.addAttribute("bookList", bookList);
        return "/book/inventoryForm";
    }

    @GetMapping("sales.do")
    public String addSales(@RequestParam("bookno") int bookno, @RequestParam("sid") String sid, Model model) throws Exception {
        Member member = memberService.getMember(sid);
        model.addAttribute("stel", member.getTel());
        model.addAttribute("semail", member.getEmail());
        Book book = bookService.getBook(bookno);
        book.setAmount(bookService.getAmount(bookno));
        model.addAttribute("book", book);
        return "/book/payment";
    }

    @GetMapping("payLoading.do")
    @ResponseBody
    public List<Payment> payLoading(@RequestParam("stype") String stype, Model model){
        PaymentLoad payMethod = new PaymentLoad();
        List<Payment> payList = payMethod.getPaymentList(stype);
        return payList;
    }

    @RequestMapping(value="bankIdLoading.do", produces="text/html; charset=UTF-8", method=RequestMethod.GET)
    @ResponseBody
    public String bankIdLoading(@RequestParam("scom") int scom, Model model){
        PaymentLoad payMethod = new PaymentLoad();
        String bankId = payMethod.getBankIdLoad(scom);
        return bankId;
    }
}
