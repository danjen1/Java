
import java.util.Scanner;

public class TheSumOfSetOfNumbers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Until what? ");
        int end = Integer.parseInt(reader.nextLine());
        int start = 0;
        int count = 1;
        while (count <= end){
            start += count;
            count++;
            
        }
        System.out.println("Sum is " + start);
    }
}
