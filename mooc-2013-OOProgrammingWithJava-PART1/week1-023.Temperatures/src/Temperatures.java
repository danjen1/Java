
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        while (true){
            System.out.println("Input Floating Point Number: ");
            double num = Double.parseDouble(reader.nextLine());
            if (num > -30 && num < 40){
                Graph.addNumber(num);
            }
        }
    }
}
