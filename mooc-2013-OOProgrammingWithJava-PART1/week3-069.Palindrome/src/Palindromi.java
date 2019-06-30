
import java.util.Scanner;

public class Palindromi {

    public static String reverse(String text) {
        int i = text.length();
        String work = "";
        while (i > 0) {
            work += text.substring(i - 1, i);
            i--;
        }
        return work;
    }

    public static boolean palindrome(String text) {
        return text.equals(reverse(text));
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type a text: ");
        String text = reader.nextLine();
        if (palindrome(text)) {
            System.out.println("The text is a palindrome!");
        } else {
            System.out.println("The text is not a palindrome!");
        }
    }
}
