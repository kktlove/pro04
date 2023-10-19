package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachVO {
    private String uuid;
    private String uploadpath;
    private String filename;
    private String filetype;
    private int bno;
}
