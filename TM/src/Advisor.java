import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Advisor implements Serializable
{
    private String ID;
    private String name;
    private String email;
    private String DSID;
    private ArrayList<Attendance> attendance;
    private ArrayList<Goal> goal;
    private ArrayList<Coaching> Coaching;


    public Advisor(String ID, String name, String email, String DSID) throws IOException
    {
        ArrayList<Attendance> newAttendance = new ArrayList<>();
        ArrayList<Goal> newGoal = new ArrayList<>();
        ArrayList<Coaching> newCoaching = new ArrayList<>();
        setName(name);
        setID(ID);
        setDSID(DSID);
        setEmail(email);
        setAttendance(newAttendance);
        setGoal(newGoal);
        setCoaching(newCoaching);
        System.out.println("Adding " + name + " to the database.");
        DB.add(this);
    }

    public Advisor() throws IOException
    {
        ArrayList<Attendance> newAttendance = new ArrayList<>();
        ArrayList<Goal> newGoal = new ArrayList<>();
        ArrayList<Coaching> newCoaching = new ArrayList<>();
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
        setAttendance(newAttendance);
        setGoal(newGoal);
        setCoaching(newCoaching);
        DB.add(this);
        System.out.println("Adding " + name + " to the database.");

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
        /*for (Attendance items : attendance)
        {
            items.print();

        }
        System.out.println();
        */
        /*
        System.out.println("Goal:");

        for (Goal items : goals)
        {
            items.print();
        }
        */
    }


    /*
    Getters and Setters
     */
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

    public void setAttendance(ArrayList<Attendance> attendance)
    {
        this.attendance = attendance;
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

    public ArrayList<Attendance> getAttendance()
    {
        return attendance;
    }

    public ArrayList<Goal> getGoal()
    {
        return goal;
    }

    public void setGoal(ArrayList<Goal> goal)
    {
        this.goal = goal;
    }

    public ArrayList<Coaching> getCoaching()
    {
        return Coaching;
    }

    public void setCoaching(ArrayList<Coaching> coaching)
    {
        Coaching = coaching;
    }
}

