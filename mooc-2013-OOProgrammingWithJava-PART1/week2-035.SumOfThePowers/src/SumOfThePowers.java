 
import java.util.Scanner;
 
public class SumOfThePowers {
 
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type a number: ");
        double pow = Double.parseDouble(reader.nextLine());
        int count = 0;
        int sum = 0;
        while (count <= pow){
            sum += (int)Math.pow(2, count);
            System.out.println(sum);
            count ++;
        }
        System.out.println("The result is " + sum);
       
    }
}
 