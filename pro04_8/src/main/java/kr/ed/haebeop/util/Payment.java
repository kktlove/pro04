package kr.ed.haebeop.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String stype;
    private int scomn;
    private String scom;
    private String pat = "^[0-9]{11,16}";
}
