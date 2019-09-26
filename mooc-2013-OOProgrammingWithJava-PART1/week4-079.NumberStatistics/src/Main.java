import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int counter = 0;
        NumberStatistics sum = new NumberStatistics();
        NumberStatistics even = new NumberStatistics();
        NumberStatistics odd = new NumberStatistics();
        while (counter != -1){
            System.out.println("Type numbers: ");
            counter = reader.nextInt();
            if (counter == -1) {
                break;
            }else {
            sum.addNumber(counter);
 
            if (counter % 2 == 0){
                even.addNumber(counter);
            }else{
                odd.addNumber(counter);
            }
        }
        }
        System.out.println("Sum: " + sum.sum());
        System.out.println("Sum of even: " + even.sum());
        System.out.println("Sum of odd: " + odd.sum());
    }
    }
 