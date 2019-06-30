
import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("First: ");
        int f = Integer.parseInt(reader.nextLine());
        System.out.println("Second: ");
        int g = Integer.parseInt(reader.nextLine());
        
        while (f <= g) {
            System.out.println(f);
            f++;
        }
        
        
        // write your code here

    }
}
