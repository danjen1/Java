import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Advisor implements Serializable
{

    private String name;
    private String EID;
    private String email;
    private ArrayList<Attendance> attendance = new ArrayList<>();
    private ArrayList<Goal> goal = new ArrayList<>();
    private ArrayList<Coaching> coach = new ArrayList<>();

    public Advisor(String name, String EID, String email) throws IOException
    {
        setName(name);
        setEID(EID);
        setEmail(email);
        ArrayList<Attendance> attend = new ArrayList<>();
        ArrayList<Goal> goal = new ArrayList<>();
        ArrayList<Coaching> coach = new ArrayList<>();

        DB.add(this);
    }

    public void print()
    {
            System.out.println("Advisor Information: \n" + getName() + " ");
            System.out.print("EID: " + getEID() + "\tEmail: " + getEmail());

            System.out.println("\n" + "Attendance Records:");
            System.out.println("In Progress\n\n");
    }




    /*
    Getters and Setters
     */
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEID()
    {
        return EID;
    }

    public void setEID(String EID)
    {
        this.EID = EID;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public ArrayList<Attendance> getAttendance()
    {
        return attendance;
    }

    public void setAttendance(ArrayList<Attendance> attendance)
    {
        this.attendance = attendance;
    }

    public ArrayList<Goal> getGoal()
    {
        return goal;
    }

    public void setGoal(ArrayList<Goal> goal)
    {
        this.goal = goal;
    }

    public ArrayList<Coaching> getCoach()
    {
        return coach;
    }

    public void setCaoch(ArrayList<Coaching> coach)
    {
        this.coach = coach;
    }


}
