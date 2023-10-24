package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookno;
    private String title;
    private String fcover;
    private String bcover;
    private String bpic;
    private String blist;
    private String bcoment;
    private String pubcom;
    private String pubdate;
    private String author;
    private int price;
    private String pfile;
    private String memo;
    private String regdate;
    private int amount = 0;
}
