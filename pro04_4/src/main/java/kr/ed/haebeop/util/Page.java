package kr.ed.haebeop.util;

import lombok.Data;

@Data
public class Page {
    private int offset = 0;
    private int size = 5;
    private int curpage = 1;
    public void generateOffset(){
        this.generateOffset(this.curpage, this.size);
    }
    public void generateOffset(int curpage, int size){
        this.size = size;
        this.curpage = curpage;
        this.offset = curpage * size - size;
    }
}
