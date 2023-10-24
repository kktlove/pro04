package kr.ed.haebeop.service;

import kr.ed.haebeop.domain.Book;
import kr.ed.haebeop.persistence.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookMapper bookMapper;

    @Override
    public void bookInsert(Book book) {
        bookMapper.bookInsert(book);
    }

    @Override
    public void bookUpdate(Book book) {
        bookMapper.bookUpdate(book);
    }

    @Override
    public void bookDelete(int bookno) {
        bookMapper.bookDelete(bookno);
    }

    @Override
    public List<Book> getBookList() {
        return bookMapper.getBookList();
    }

    @Override
    public List<Book> getBookList1(int offset, int size) {
        return bookMapper.getBookList1(offset, size);
    }

    @Override
    public List<Book> getBookList2(String field, String query, int offset, int size) {
        return bookMapper.getBookList2(field, query, offset, size);
    }

    @Override
    public Book getBook(int bookno) {
        return bookMapper.getBook(bookno);
    }

    @Override
    public int totalCount() {
        return bookMapper.totalCount();
    }

    @Override
    public int searchCount(String field, String query) {
        return bookMapper.searchCount(field, query);
    }

    @Override
    public int getAmount(int pno) {
        int inven = 0;
        Integer salesAmount = bookMapper.getSalesAmount(pno);
        Integer invenAmount = bookMapper.getInventoryAmount(pno);
        if(salesAmount!=null && invenAmount!=null) {
            inven = invenAmount - salesAmount;
        } else if(invenAmount!=null){
            inven = invenAmount;
        } else {
            inven = 0;
        }
        return inven;
    }
}