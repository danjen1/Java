
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grades list = new Grades();

        Scanner in = new Scanner(System.in);
        System.out.println("Type exam scores, -1 completes: ");
        while (in.hasNextInt()) {
            int grade = Integer.parseInt(in.nextLine());
            if (grade == -1) {
                break;
            }
            list.addAScore(grade);
        }
        list.toPrint();

    }

}
