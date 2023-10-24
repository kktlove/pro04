package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.AttachVO;
import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.FileBoard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileBoardMapper {
    @Select("select num+1 from fileboard order by num desc limit 0,1")
    public int nextBoardNum();

    @Insert("insert into fileboard values (default, #{title}, #{content}, #{author}, #{ip}, default, default, default, default, default)")
    public void register(FileBoard fileBoard);

    @Select("select num from fileboard order by num desc limit 0,1")
    public int lastBoardBum();

    @Select("select * from fileboard order by bno desc")
    public List<FileBoard> getFileBoardList();

    @Select("select * from fileboard where num=#{num}")
    public FileBoard getFileBoard(int num);

    @Update("update fileboard set title=#{title}, content=#{content} where num=#{num}")
    public void updateFileBoard(FileBoard fileboard);

    @Delete("delete from fileboard where num=#{num}")
    public void deleteFileBoard(int num);

    @Update("update fileboard set readcount=readcount+1 where num=#{num}")
    public void updateReadCount(int num);

    @Select("select * from fileboard order by num desc limit #{offset}, #{size}")
    public List<FileBoard> getBoardList1(@Param("offset") int offset, @Param("size") int size);

    @Select("select * from fileboard where ${field} like CONCAT('%',#{query},'%') order by num desc limit #{offset}, #{size}")
    public List<FileBoard> getBoardList2(@Param("offset") int offset, @Param("size") int size,@Param("field") String field, @Param("query") String query);

    @Select("select count(*) from fileboard")
    public int totalCount();

    @Select("select count(*) from fileboard where ${field} like CONCAT('%',#{query},'%')")
    public int searchCount(@Param("field") String field, @Param("query") String query);
}
