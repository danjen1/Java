 
import java.util.Scanner;
 
public class ReversingText {
 
    public static String reverse(String text) {
        int i = text.length();
        String work = "";
        while (i > 0){
        work += text.substring(i - 1, i);
        i--;
    }
        return work;
    }
 
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Type in your text: ");
        String text = reader.nextLine();
        System.out.println("In reverse order: " + reverse(text));
    }
}
 