import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type a number:");
        int top = Integer.parseInt(reader.nextLine());
        int sum = 1;
        int count = 1;
        
        while (count <= top){
            sum *= count;
            System.out.println(sum);
            count++;
        }
        System.out.println("factorial is " + sum);
    }
}
