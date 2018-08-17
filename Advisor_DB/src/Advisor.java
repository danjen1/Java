import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Advisor implements Serializable
{

    private String name, EID, email, DSID, status, shift_type, shift, phone, t_zone, bDay, address;
    private Boolean diff = false;
    private LocalDate DOH;
    private ArrayList<Attendance> attendance = new ArrayList<>();
    private ArrayList<Goal> goal = new ArrayList<>();
    private ArrayList<Coaching> coach = new ArrayList<>();


    public Advisor() throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");
        ArrayList<Attendance> attend = new ArrayList<>();
        ArrayList<Goal> goal = new ArrayList<>();
        ArrayList<Coaching> coach = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Boolean go = true;

        System.out.println("Employee ID: ");
        setEID(in.nextLine());
        System.out.println("Name: ");
        setName(in.nextLine());
        System.out.println("Email: ");
        setEmail(in.nextLine());
        System.out.println("DSID: ");
        setDSID(in.nextLine());
        System.out.println("Status: ");
        setStatus(in.nextLine());
        System.out.println("Shift Type: ");
        setShift_type(in.nextLine());
        System.out.println("Shift Differential? (y)/(n)");
        String str = in.nextLine();
        if (str.equals("y") || str.equals("yes") || str.equals("Yes") || str.equals("Y"))
        {
            setDiff(true);
        }
        System.out.println("Shift: ");
        setShift(in.nextLine());
        System.out.println("Phone Number: ");
        setPhone(in.nextLine());
        System.out.println("Time Zone: ");
        setT_zone(in.nextLine());
        System.out.println("DOH: ");
        setDOH(LocalDate.parse(in.nextLine(), mdy));
        System.out.println("bDay: ");
        setbDay(in.nextLine());
        System.out.println("Address: ");
        setAddress(in.nextLine());

        System.out.println("Adding " + name + " to the database.");
        DB.add(getName(), this);

    }

    public Advisor(String name, String EID, String DSID, String email, String status, String shift_type,
                   String shift, Boolean diff, String phone, String t_zone, String DOH, String bDay,
                   String address) throws IOException
    {
        ArrayList<Attendance> attend = new ArrayList<>();
        ArrayList<Goal> goal = new ArrayList<>();
        ArrayList<Coaching> coach = new ArrayList<>();
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");

        setName(name);
        setEID(EID);
        setDSID(DSID);
        setEmail(email);
        setStatus(status);
        setShift_type(shift_type);
        setShift(shift);
        setPhone(phone);
        setT_zone(t_zone);
        setDOH(LocalDate.parse(DOH, mdy));
        setbDay(bDay);
        setAddress(address);
        setGoal(goal);
        setCoach(coach);
        setAttendance(attend);
        setDiff(diff);
        System.out.println("Adding " + name + " to the database.");
        DB.add(getName(), this);
    }

    public void print()
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");

        System.out.println("EID: " + getEID() + "\nEmail: " + getEmail() + "\nPhone Number: " + getPhone() + "\nStatus: " + getStatus() + "\nShift Type: " + getShift_type() +
                "\nShift: " + getShift() + "\nDiff: " + getDiff() + "\nTime Zone: " + getT_zone() + "\nDOH: " + getDOH().format(mdy) + "\nbDay: " + getbDay() + "\nAddress: " + getAddress() + "\n");

        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println("\n" + getName() + " Attendance Records:");
        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println();

        for (Attendance item : getAttendance())

        {
           // item.print();

        }
        System.out.println();
        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println("\n" + getName() + " Goals");
        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println();
        for (Goal item : getGoal())
        {
            item.print();
        }
        System.out.println();
        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println("\n" + getName() + " Coaching Notes:");
        for (int j = 0; j < 50; j++)
        {
            System.out.print("-");
        }
        System.out.println();
        for (Coaching item : getCoach())
        {
            item.print();
        }
        System.out.println();

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

    public void setCoach(ArrayList<Coaching> coach)
    {
        this.coach = coach;
    }

    public String getDSID()
    {
        return DSID;
    }

    public void setDSID(String DSID)
    {
        this.DSID = DSID;
    }
    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getShift_type()
    {
        return shift_type;
    }

    public void setShift_type(String shift_type)
    {
        this.shift_type = shift_type;
    }

    public String getShift()
    {
        return shift;
    }

    public void setShift(String shift)
    {
        this.shift = shift;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getT_zone()
    {
        return t_zone;
    }

    public void setT_zone(String t_zone)
    {
        this.t_zone = t_zone;
    }

    public LocalDate getDOH()
    {
        return DOH;
    }

    public void setDOH(LocalDate DOH)
    {
        this.DOH = DOH;
    }

    public String getbDay()
    {
        return bDay;
    }

    public void setbDay(String bDay)
    {
        this.bDay = bDay;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public Boolean getDiff()
    {
        return diff;
    }

    public void setDiff(Boolean diff)
    {
        this.diff = diff;
    }


}
