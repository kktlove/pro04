package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Carry {
    private int cno;
    private int sno;
    private int ctype;
    private String ccom;
    private String cman;
    private String ctel;
    private String ccode;
    private int cstat;
    private String id;
    private String tel;
    private String addr1;
    private String addr2;
    private String postcode;
    private String cmemo;
    private float pasti;
    private float casti;
    private String saticom;
    private String sdate;
    private String edate;
}
