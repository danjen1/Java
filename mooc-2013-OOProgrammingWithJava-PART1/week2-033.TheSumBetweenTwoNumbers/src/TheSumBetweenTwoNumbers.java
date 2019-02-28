
import java.util.Scanner;


public class TheSumBetweenTwoNumbers {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("first:");
        int f = Integer.parseInt(reader.nextLine());
        System.out.println("second:");
        int g = Integer.parseInt(reader.nextLine());
        
        int sum = 0;
        while (f <= g){
            sum += f;
            f++;
  
        }
        
        System.out.println("The sum " + sum);
    }
}
