import java.util.*;

public class Roster
{
    private static ArrayList<Student> roster = new ArrayList<>();

    private static void remove(String ID)
    {
        for (Student item : roster)
        {
            if (ID.equals(item.getID()))
            {
               roster.remove(item);
               return;
            }
        }
        System.out.println("Student not found, no ID match");
    }
    private static void printAll()
    {
        for (Student item : roster)
        {
            item.print();
        }
        System.out.println();
    }
    private static void print_average_grade(String ID)
    {
        for (Student item : roster)
        {

            if (ID.equals(item.getID()))
            {
                double total = 0;
                for (double grade : item.getGrades())
                {
                    total += grade;
                }
                total = total / item.getGrades().length;
                System.out.print("Student ID " + item.getID() + ": average of " + item.getGrades().length + " grades for " + item.getFirstName() + " is: ");
                System.out.printf("%.2f", total);
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Student ID not found");
        System.out.println();
    }
    private static void print_invalid_emails()
    {
        for (Student item : roster)
        {
            if (!(item.getEmail().contains("@")) || (item.getEmail().contains(" ") || (!(item.getEmail().contains(".")))))
            {
                System.out.println("Student " + item.getFirstName() + " email is invalid: " + item.getEmail());
                System.out.println();
                return;
            }

        }
        System.out.println("All eMails are correct");
        System.out.println();
    }
    private static void add(String ID, String firstName, String lastName, String Email, int age, double grade1, double grade2, double grade3, double grade4, double grade5)
    {
        double grades[] = {grade1, grade2, grade3, grade4, grade5};
        Student newStud = new Student(ID, firstName, lastName, Email, age, grades);
        roster.add(newStud);
    }

    public static void main(String[] args)
    {
        add("001", "IG", "Horowitz", "Horowitz@protonmail.com", 36, 91.91, 92.92, 93.93, 94.94, 75.75);
        add("002", "Rod", "Rosenstein", "rod_roddy@icloud.com", 37, 98.78, 89.98, 93.45, 99.89, 100);
        add("003", "Jeff", "Sessions", "who_knows @icloud.com", 10, 100, 89.75, 95.85, 99.89, 100);

        printAll();
        print_average_grade("001");
        print_average_grade("002");
        print_average_grade("003");
        print_invalid_emails();

    }
}
