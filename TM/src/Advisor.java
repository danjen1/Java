import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Advisor implements Serializable
{
    private String ID;
    private String name;
    private String email;
    private String DSID;
    private ArrayList<Attend> attend;


    public Advisor(String ID, String name, String email, String DSID)
    {
        ArrayList<Attend> tempAttend = new ArrayList<>();
        setName(name);
        setID(ID);
        setDSID(DSID);
        setEmail(email);
        setAttend(tempAttend);
    }

    public Advisor() throws IOException
    {
        ArrayList<Attend> tempAttend = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            Boolean go = true;
            while (go)
            {
                System.out.println("Employee ID: ");
                ID = in.nextLine();
                System.out.println("Name: ");
                name = in.nextLine();
                System.out.println("Email: ");
                email = in.nextLine();
                System.out.println("DSID: ");
                DSID = in.nextLine();
                go = false;

        }
        setName(name);
        setID(ID);
        setDSID(DSID);
        setEmail(email);
        setAttend(tempAttend);
        DB.addAdv(this);
    }




    /*****************
     **Print Methods**
     *****************/
    public void print()
    {
        System.out.println("Advisor Information: \n" + getName() + " ");
        System.out.print("EID: " + getID() + "\tEmail: " + getEmail() + "\tAge: " + getDSID() + "\n");

        System.out.println("**************************\n" + "Attendance Records:");
        System.out.println("In Progress\n\n");
        /*for (Attend items : attend)
        {
            items.print();

        }
        System.out.println();
        */
        /*
        System.out.println("Goals:");

        for (Goal items : goals)
        {
            items.print();
        }
        */
    }





























    public void setID(String ID)
    {
        this.ID = ID;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String Email)
    {
        this.email = Email;
    }

    public void setDSID(String DSID)
    {
        this.DSID = DSID;
    }

    public void setAttend(ArrayList<Attend> attend)
    {
        this.attend = attend;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getDSID()
    {
        return DSID;
    }

    public ArrayList<Attend> getAttend()
    {
        return attend;
    }

    /*
    public void print()
    {
        grades = getGrades();
        System.out.print("ID: " + getID() + "\tFirst Name: " + getFirstName() + "\tLast Name: " +
                getLastName() + "\tEmail: " + getEmail() + "\tAge: " + getAge());
        System.out.print("\tGrades: {");
        System.out.println(grades[0] + ", " + grades[1] + ", " + grades[2] + ", " + grades[3] + ", " + grades[4] + "}");
    }
    */
}

