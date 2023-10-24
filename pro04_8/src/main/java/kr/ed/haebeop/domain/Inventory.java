package kr.ed.haebeop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private int ino;
    private int pno;
    private int ptype;
    private String title;
    private int cost;
    private int amount;
    private String regdate;
}
