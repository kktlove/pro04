package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("select * from board order by regdate desc limit #{offset}, #{size}")
    public List<Board> getBoardList1(@Param("offset") int offset, @Param("size") int size);

    @Select("select * from board where ${field} like '%${query}%' order by regdate desc limit ${offset}, ${size}")
    public List<Board> getBoardList2(@Param("offset") int offset, @Param("size") int size, String field, String query);

}
