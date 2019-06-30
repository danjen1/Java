
import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberDrawn = drawNumber();
        int count = 0;
        while (true){
        System.out.println("Guess a number:");
        int guess = Integer.parseInt(reader.nextLine());
        if (guess == numberDrawn){
            System.out.println("Congratulations, your guess is correct!");
            count++;
            break;
        }else if (guess < numberDrawn){
            System.out.print("The number is greater, ");
            count++;
        }else {
            System.out.print("The number is lesser, ");
            count++;
        }
        System.out.println("guesses made: " + count);
        } 
        
    }

    // DO NOT MODIFY THIS!
    private static int drawNumber() {
        return new Random().nextInt(101);
    }
}
