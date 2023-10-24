import kr.ed.haebeop.util.CardSecurity;

public class CardNumEx {
    public static void main(String[] args) {
        CardSecurity card = new CardSecurity();
        boolean pw = card.compareCardNum("457973007124705");
        System.out.println(pw);
    }
}
