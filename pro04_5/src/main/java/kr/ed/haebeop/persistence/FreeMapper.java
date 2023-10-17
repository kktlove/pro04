package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.Board;
import kr.ed.haebeop.domain.Free;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FreeMapper {
    @Select("select * from free order by regdate desc limit #{offset}, #{size}")
    public List<Free> getFreeList1(@Param("offset") int offset, @Param("size") int size);

    @Select("select * from free where ${field} like CONCAT('%',#{query},'%') order by regdate desc limit #{offset}, #{size}")
    public List<Free> getFreeList2(@Param("offset") int offset, @Param("size") int size, @Param("field") String field, @Param("query") String query);

    @Select("select count(*) from free")
    public int totalCount();

    @Select("select count(*) from free where ${field} like CONCAT('%',#{query},'%')")
    public int searchCount(@Param("field") String field, @Param("query") String query);

    @Select("select * from free where bno=#{bno}")
    public Free getFree(int bno);

    @Update("update free set visited=visited+1 where bno=#{bno}")
    public void updateVisitedCount(int bno);

    @Update("update free set rec=rec+1 where bno=#{bno}")
    public void updateRecCount(int bno);

    @Update("update free set title=#{title}, content=#{content} where bno=#{bno}")
    public void freeUpDate(Free free);

    @Delete("delete from free where bno=#{bno}")
    public void freeDelete(int bno);

    @Insert("insert into free values (default, #{title}, #{content}, default, default, #{author}, default)")
    public void freeInsert(Free free);
}
