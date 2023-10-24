package kr.ed.haebeop.persistence;

import kr.ed.haebeop.domain.AttachVO;
import kr.ed.haebeop.domain.FileBoard;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttachMapper {
    @Insert("INSERT INTO attach (uuid, uploadpath, filename, filetype, bno) VALUES (#{uuid}, #{uploadpath}, #{filename}, #{filetype}, #{bno})")
    public int insertAttach(AttachVO attachVO);

    @Select("select * from attach where bno=#{bno}")
    public List<AttachVO> getFileList(int num);

    @Update("update attach set filename=#{filename}, filetype=#{filetype} where bno=#{bno}")
    public void updateAttach(AttachVO attach);

    @Delete("delete from fileboard where bno=#{bno}")
    public void deleteAttach(int bno);
}
