package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sales {
    private int sno;
    private int pno;
    private int ptype;
    private String title;
    private int price;
    private int amount;
    private int money;
    private String id;
    private String stype;
    private String scom;
    private String snum;
    private String spass;
    private String sdate;
}
