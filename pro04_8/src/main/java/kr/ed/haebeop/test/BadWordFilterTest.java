import kr.ed.haebeop.util.BadWordFilter;

public class BadWordFilterTest {
    public static void main(String[] args) {
        BadWordFilter filter = new BadWordFilter();
        if(filter.check("병딱")){
            System.out.println("비속어나 욕설이 존재합니다.");
        } else {
            System.out.println("비속어나 욕설이 포함되어 있지 않습니다.");
        }
    }
}
