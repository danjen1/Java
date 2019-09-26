
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class Grades {

    private int[] grades;

    public Grades() {
        grades = new int[6];
    }

    public void addAScore(int score) {
        if (score < 0 || score > 60) {
            return;
        }
        int theGrade = grade(score);
        grades[theGrade]++;
    }

    public void toPrint() {
        System.out.println("Grade distribution: ");
        for (int i = 5; i >= 0; i--) {
            System.out.println(i + ": " + stars(grades[i]));
        }
        System.out.println("Acceptance percentage: " + acceptancePercentage());
    }

    private String stars(int n) {
        String start = "";
        for (int i = 0; i < n; i++) {
            start += "*";
        }
        return start;
    }

    private int grade(int score) {
        if (score < 30) {
            return 0;
        }
        if (score < 35) {
            return 1;
        }
        if (score < 40) {
            return 2;
        }
        if (score < 45) {
            return 3;
        }
        if (score < 50) {
            return 4;
        }
        return 5;
    }

    private double acceptancePercentage() {
        double all = 0;
        for (int number : grades) {
            all += number;
        }
        double failed = grades[0];
        return 100 * (all - failed) / all;
    }

}

/* With ArrayList non refactored 
public class Grades {

    ArrayList<Integer> allGrades;
    private double count, accepted;

    public Grades() {
        this.allGrades = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            this.allGrades.add(0);
        }
    }

    public void processGrade(int grade) {
        if (grade >= 0 && grade <= 60) {
            count++;
            if (grade >= 0 && grade < 30) {
                this.allGrades.set(0, this.allGrades.get(0) + 1);

            } else if (grade >= 30 && grade <= 34) {
                this.allGrades.set(1, this.allGrades.get(1) + 1);
                accepted++;
                
            } else if (grade >= 35 && grade <= 39) {
                this.allGrades.set(2, this.allGrades.get(2) + 1);
                accepted++;

            } else if (grade >= 40 && grade <= 44) {
                this.allGrades.set(3, this.allGrades.get(3) + 1);
                accepted++;

            } else if (grade >= 45 && grade <= 49) {
                this.allGrades.set(4, this.allGrades.get(4) + 1);
                accepted++;

            } else if (grade >= 50 && grade <= 60) {
                this.allGrades.set(5, this.allGrades.get(5) + 1);
                accepted++;

            }
        }

    }

    public void printGrades() {
        System.out.println("Grade distribution: ");
        for (int i = 5; i >= 0; i--) {
            System.out.print(i + ":");
            int temp = allGrades.get(i);
            while (temp > 0) {
                System.out.print("*");
                temp--;
            }
            System.out.println("");
        }
        double summary = 100 * (accepted / count);
        System.out.println("Acceptance percentage: " + summary);
    }
}
 */
