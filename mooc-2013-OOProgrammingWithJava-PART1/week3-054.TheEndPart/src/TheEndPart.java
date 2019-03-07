import java.util.Scanner;

public class TheEndPart {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Thpe a word");
        String word = reader.nextLine();
        System.out.println("Length of the end part");
        int a = Integer.parseInt(reader.nextLine());
        int b = word.length();
        System.out.println("Result: " + word.substring((b-a), (b)));
        
        
    }
}
