package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Book;
import kr.ed.haebeop.domain.Inventory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book values (default, #{title}, #{fcover}, #{bcover}, #{bpic}, #{blist}, #{bcoment}, #{pubcom}, #{pubdate}, #{author}, #{price}, #{pfile}, #{memo}, default, default)")
    public void bookInsert(Book book);

    @Update("update book set title=#{title}, fcover=#{fcover}, bcover=#{bcover}, bpic=#{bpic}, bcoment=#{bcoment}, pubcom=#{pubcom}, pubdate=#{pubdate}, author=#{author}, price=#{price}, pfile=#{pfile}, memo=#{memo} where bookno=#{bookno}")
    public void bookUpdate(Book book);

    @Delete("delete from book where bookno=#{bookno}")
    public void bookDelete(int bookno);

    @Select("select * from book order by bookno desc")
    public List<Book> getBookList();

    @Select("select * from book order by bookno desc limit #{offset}, #{size}")
    public List<Book> getBookList1(@Param("offset") int offset, @Param("size") int size);

    @Select("select * from book where ${field} like CONCAT('%',#{query},'%') order by bookno desc limit #{offset}, #{size}")
    public List<Book> getBookList2(@Param("field") String field, @Param("query") String query, @Param("offset") int offset, @Param("size") int size);

    @Select("select * from book where bookno=#{bookno}")
    public Book getBook(int bookno);

    @Select("select count(*) from book")
    public int totalCount();

    @Select("select count(*) from book where ${field} like CONCAT('%',#{query},'%')")
    public int searchCount(@Param("field") String field, @Param("query") String query);

    @Select("select (sum(i.amount) - sum(s.amount)) as amount from inventory i inner join sales s on i.pno=s.pno where i.pno=#{pno} group by i.pno, s.pno")
    public Integer getAmount(int pno);

    @Select("select sum(amount) as amount from inventory where pno=#{pno} group by pno")
    public Integer getInventoryAmount(int pno);

    @Select("select sum(amount) as amount from sales where pno=#{pno} group by pno")
    public Integer getSalesAmount(int pno);

    @Insert("insert into inventory values (default, #{pno}, #{ptype}, #{title}, #{cost}, #{amount}, default)")
    public void addInventory(Inventory inven);

}
