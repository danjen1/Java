
import java.util.Scanner;

public class WordInsideWord {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("First Word: ");
        String a = reader.nextLine();
        System.out.println("Second Word: ");
        String b = reader.nextLine();
        if (a.indexOf(b) == -1) {
            System.out.println("The word " + "'" + b + "'" + " is not found in the word " + "'" + a + "'");
        } else {
            System.out.println("The word " + "'" + b + "'" + " is found in the word " + "'" + a + "'");

        }
       
            
}
}