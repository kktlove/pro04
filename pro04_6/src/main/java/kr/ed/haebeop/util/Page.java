package kr.ed.haebeop.util;

import lombok.Data;

@Data
public class Page {
    private int offset = 0;
    private int size = 5;
    private int curpage = 1;
    private int total;
    private int pageCount;
    public void generateOffset(){
        this.generateOffset(this.curpage, this.size);
    }
    public void generateOffset(int curpage, int size){
        this.size = size;
        this.curpage = curpage;
        this.offset = curpage * size - size;
    }
    public void ComputePage(int total){
        this.total = total;
        if(total % size != 0) {
            this.pageCount = ((int) total / size) + 1;
        } else {
            this.pageCount = (int) total / size;
        }
    }
}
