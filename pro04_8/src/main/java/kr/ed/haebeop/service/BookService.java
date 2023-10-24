package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    public void bookInsert(Book book);
    public void bookUpdate(Book book);
    public void bookDelete(int bookno);
    public List<Book> getBookList();
    public List<Book> getBookList1(int offset, int size);
    public List<Book> getBookList2(String field, String query, int offset, int size);
    public Book getBook(int bookno);
    public int totalCount();
    public int searchCount(String field, String query);
    public int getAmount(int pno);
}
