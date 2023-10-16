package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board order by regdate desc limit #{offset}, #{size}")
    public List<Board> getBoardList1(@Param("offset") int offset, @Param("size") int size);

    @Select("select * from board where ${field} like CONCAT('%',#{query},'%') order by regdate desc limit #{offset}, #{size}")
    public List<Board> getBoardList2(@Param("offset") int offset, @Param("size") int size,@Param("field") String field, @Param("query") String query);

    @Select("select count(*) from board")
    public int totalCount();

    @Select("select count(*) from board where ${field} like CONCAT('%',#{query},'%')")
    public int searchCount(@Param("field") String field, @Param("query") String query);

    @Select("select * from board where bno=#{bno}")
    public Board getBoard(int bno);

    @Update("update board set visited=visited+1 where bno=#{bno}")
    public void updateVisitedCount(int bno);

    @Update("update board set title=#{title}, content=#{content} where bno=#{bno}")
    public void boardUpDate(Board board);

    @Delete("delete from board where bno=#{bno}")
    public void boardDelete(int bno);

    @Insert("insert into board values (default, #{title}, #{content}, default, default)")
    public void boardInsert(Board board);
}
