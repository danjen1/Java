package Day12;
import java.util.*;

public class Student extends Person{
    private int[] testScores;

    /*
     *   Class Constructor
     *
     *   @param firstName - A string denoting the Person's first name.
     *   @param lastName - A string denoting the Person's last name.
     *   @param id - An integer denoting the Person's ID number.
     *   @param scores - An array of integers denoting the Person's test scores.
     */
    // Write your constructor here
    Student(String firstName, String lastName, int idNumber, int[] scores)
    {
        super(firstName, lastName, idNumber);
        this.testScores = scores;

    }

    /*
     *   Method Name: calculate
     *   @return A character denoting the grade.
     */
    // Write your method here
    public char calculate(){
        char result;
        int avg = 0;
        for (int i : testScores)
        {
            avg += i;
        }
        avg = avg / testScores.length;

        if (avg >= 90)
        {
            result = 'O';
        } else if (avg >= 80)
        {
            result = 'E';
        } else if (avg >= 70)
        {
            result = 'A';
        } else if (avg >= 55)
        {
            result = 'P';
        } else if (avg >= 40)
        {
            result = 'D';
        }else
        {
            result = 'T';
        }
        return result;
    }
}