package kr.ed.haebeop.domain;

import lombok.Data;

@Data
public class FileBoard {
    private int num;
    private String title;
    private String content;
    private String author;
    private String ip;
    private int readcount;
    private String regDate;
    private int reRef;
    private int reLev;
    private int reSeq;
}
