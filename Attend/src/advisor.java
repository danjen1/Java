import java.util.*;

public class advisor
{
    private String ID;
    private String name;
    private String surname;
    private String email;

    private int age;
    private ArrayList<events> records = new ArrayList<>();


    public advisor(String ID, String firstName, String lastName, String Email, int age, ArrayList<events> records)
    {
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(Email);
        setAge(age);
        setRecords(records);
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setFirstName(String firstName)
    {
        this.name = firstName;
    }

    public void setLastName(String lastName)
    {
        this.surname = lastName;
    }

    public void setEmail(String Email)
    {
        this.email = Email;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setRecords(ArrayList<events> record)
    {
        this.records = record;
    }

    public String getID()
    {
        return ID;
    }

    public String getFirstName()
    {
        return name;
    }

    public String getLastName()
    {
        return surname;
    }

    public String getEmail()
    {
        return email;
    }

    public int getAge()
    {
        return age;
    }

    /*public double[] getGrades()
    {
        return grades;
    } */

    public void print()
    {
        //grades = getGrades();
        System.out.print("ID: " + getID() + "\tFirst Name: " + getFirstName() + "\tLast Name: " +
                getLastName() + "\tEmail: " + getEmail() + "\tAge: " + getAge());
        System.out.print("\tGrades: {");
        //System.out.println(grades[0] + ", " + grades[1] + ", " + grades[2] + ", " + grades[3] + ", " + grades[4] + "}");
    }
}

