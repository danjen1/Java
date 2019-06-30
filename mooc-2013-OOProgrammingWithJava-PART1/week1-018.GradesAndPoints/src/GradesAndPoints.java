
import java.util.Scanner;

public class GradesAndPoints {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int grade = Integer.parseInt(reader.nextLine());
        if (grade >= 0 && grade < 30) {
            System.out.println("failed");
        }
        else if (grade >= 30 && grade <= 34) {
            System.out.println("1");
        }
        else if (grade >=35 && grade <=39) {
            System.out.println("2");
        }
        else if (grade >=40 && grade <=44) {
            System.out.println("3");
        }
        else if (grade >=45 && grade <=49) {
            System.out.println("4");
        }
        else if (grade >=50 && grade <=60) {
            System.out.println("5");
        }
        
    }
}
