
import java.util.Scanner;

public class Main {
 
    
    public static void main(String[] args) {
        LyyraCard card = new LyyraCard(20);
        LyyraCard card2 = new LyyraCard(30);
        card.payGourmet();
        card2.payEconomical();
        System.out.println("Pekka " + card.toString());
        System.out.println("Brian " + card2.toString());
        card.loadMoney(20);
        card2.payGourmet();
        System.out.println("Pekka " + card.toString());
        System.out.println("Brian " + card2.toString());
        card.payEconomical();
        card.payEconomical();
        card2.loadMoney(50);
        System.out.println("Pekka " + card.toString());
        System.out.println("Brian " + card2.toString());

        

    }
}
