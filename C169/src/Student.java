import java.util.*;

public class Student
{
    private String ID;
    private String firstName;
    private String lastName;
    private String Email;
    private int age;
    private double[] grades;

    public Student(String ID, String firstName, String lastName, String Email, int age, double[] grades)
    {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(Email);
        setAge(age);
        setGrades(grades);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setGrades(double[] grades)
    {
        this.grades = grades;
    }

    public String getID()
    {
        return ID;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return Email;
    }

    public int getAge()
    {
        return age;
    }

    public double[] getGrades()
    {
        return grades;
    }

    public void print()
    {
        grades = getGrades();
        System.out.print("ID: " + getID() + "\tFirst Name: " + getFirstName() + "\tLast Name: " +
                getLastName() + "\tEmail: " + getEmail() + "\tAge: " + getAge());
        System.out.print("\tGrades: {");
        System.out.println(grades[0] + ", " + grades[1] + ", " + grades[2] + ", " + grades[3] + ", " + grades[4] + "}");
    }
}

