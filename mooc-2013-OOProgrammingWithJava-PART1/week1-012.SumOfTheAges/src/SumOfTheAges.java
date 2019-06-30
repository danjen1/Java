 
import java.util.Scanner;
 
public class SumOfTheAges {
 
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
 
        // Implement your program here
        System.out.println("Type your Name:");
        String name = reader.nextLine();
        System.out.println("Type your age:");
        int age = Integer.parseInt(reader.nextLine());
        
         System.out.println("Type your Name:");
        String name2 = reader.nextLine();
        System.out.println("Type your age:");
        int age2 = Integer.parseInt(reader.nextLine());
        int totalAge = age + age2;
        System.out.println("");
        System.out.println(name + " and " + name2 + " are " + totalAge + " years old in total");
        
    }
}