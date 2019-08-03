import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Advisor implements Serializable
{

    private String name;
    private String EID;
    private String email;
    private String DSID;
    private String status;
    private String shift_type;
    private String shift;
    private String phone;
    private String t_zone;
    private String bDay;
    private String address;
    private String RTW;
    private String medDue;
    private String comments;
    private Boolean diff = false;
    private LocalDate DOH;
    private ArrayList<Attendance> attendance = new ArrayList<>();
    private ArrayList<Goal> goal = new ArrayList<>();
    private ArrayList<Coaching> coach = new ArrayList<>();
    private String[] types = {"Full Day", "Partial Day","HomeDT", "AppleDT", "ROD", "Total", "KinCare", "Parental", "iLOA", "LOA", "SSD", "RSL", "Bereav", "JA", "Vacation"};

    private LocalDate today = LocalDate.now();
    private LocalDate thirty = today.minusDays(30);
    private LocalDate sixty = today.minusDays(60);
    private LocalDate ninety = today.minusDays(90);
    private LocalDate oneEighty = today.minusDays(180);

    private String head = "****************************************************************************************************************************************************************************";



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

    public double[][] getAttendTotals()
    {

        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");

        double[][] totals = new double[15][5];
        for (Attendance item : getAttendance())
        {
            double sum30 = 0, sum60 = 0, sum90 = 0, sum180 = 0, sumTotal = 0;
            for (int i = 0; i < 15; i++)
            {
                if (item.getType().equals(types[i]))
                {

                    if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today.plusDays(1)))
                    {

                        sum30 += item.getHours();
                    }
                    if (item.getDate().isBefore(thirty) && item.getDate().isAfter(sixty))
                    {
                        sum60 += item.getHours();
                    }
                    if (item.getDate().isAfter(ninety) && item.getDate().isBefore(sixty))
                    {
                        sum90 += item.getHours();
                    }
                    if (item.getDate().isAfter(oneEighty) && item.getDate().isBefore(ninety))
                    {
                        sum180 += item.getHours();
                    }
                    sumTotal = sum30 + sum60 + sum90 + sum180;
                    totals[i][0] += sum30;
                    totals[i][1] += sum60;
                    totals[i][2] += sum90;
                    totals[i][3] += sum180;
                    totals[i][4] += sumTotal;
                }
            }
            for (int i = 0; i < 4; i++)
            {
                 sum30 += totals[i][0];
                 sum60 += totals[i][1];
                 sum90 += totals[i][2];
                 sum180 += totals[i][3];
                 sumTotal += totals[i][4];
            }
            totals[5][0] = sum30;
            totals[5][1] = sum60;
            totals[5][2] = sum90;
            totals[5][3] = sum180;
            totals[5][4] = sumTotal;
        }

        return totals;
    }


    /***************************
     *     Print Methods       *
     ***************************/
    public void printAttendTotals(double[][] totals)
    {

        String headerT = String.format("%-10s%9s%9s%9s%9s%12s","Days", "30", "60", "90", "180", "Annual");

        System.out.println("\nAttendance Totals: " + getName());
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);

        for (int i = 0; i < 4; i++)
        {
            String dataRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", types[i], totals[i][0], totals[i][1], totals[i][2], totals[i][3], totals[i][4]);
            System.out.println(dataRow);

        }
        String rodRow = String.format("%-16s%-9.0f%-9.0f%-9.0f%-10.0f%-9.0f", types[4], totals[4][0], totals[4][1], totals[4][2], totals[4][3], totals[4][4]);
        System.out.println(rodRow);
        System.out.println(head);
        String totRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", types[5], totals[5][0], totals[5][1], totals[5][2], totals[5][3], totals[5][4]);
        System.out.println(totRow + "\n");
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);
        for (int i = 6; i < 15; i++)
        {
            String dataRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", types[i], totals[i][0], totals[i][1], totals[i][2], totals[i][3], totals[i][4]);
            System.out.println(dataRow);
        }
        System.out.println();

    }

    public void printAdvInfo(String adv)
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");
        System.out.println("\n" + head);
        System.out.println("Advisor Information: " + getName());
        System.out.println(head);
        System.out.println("EID: " + getEID() + "\nDSID: " + getDSID() + "\nEmail: " + getEmail() + "\nPhone Number: " + getPhone() + "\nStatus: " + getStatus()  +
                "\nRTW: " + getRTW() + "\nMedical Due: " + getMedDue() + "\nShift Type: " + getShift_type() + "\nShift: " + getShift() + "\nDiff: " + getDiff() + "\nTime Zone: " + getT_zone() +
                "\nDOH: " + getDOH().format(mdy) + "\nbDay: " + getbDay() + "\nAddress: " + getAddress() + "\n");
    }

    public void printAttendEvents()
    {
        int i = 1;
        System.out.println("\nAttendance Events: " + getName());
        String headerT = String.format("%8s%12s%16s%10s", "Date", "Type", "Hours", "Comments");
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);
        for (Attendance item : getAttendance())

        {
            if (item.getDate().isAfter(oneEighty))
            {
                System.out.print(i);
                item.print();
                i++;
            }
        }
        System.out.println();
    }


    public void printCoaching()
    {
        int i = 1;
        System.out.println("\nCoaching Comments: " + getName());
        String headerT = String.format("%8s%12s%30s", "Date", "Type", "Comments");
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);
        for (Coaching item : getCoach())

        {
            System.out.print(i);
            item.print();
            i++;
        }
        System.out.println();
    }

    public void printGoals ()
    {
        int i = 1;
        System.out.println("\nGoals: " + getName());
        String headerT = String.format("%8s%10s%14s%5s%11s%99s", "Date", "Type", "Category", "Due", "Goal", "Complete");
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);
        for (Goal item : getGoal())

        {
            System.out.print(i);
            item.print();
            i++;
            System.out.println("Updates:");
            for (String thing : item.getUpdate())
            {
                System.out.println(thing);
            }
            System.out.println();
        }

    }
    public void printCoachSumm()
    {

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

    public String getRTW()
    {
        if (RTW == null)
        {
            return "N/A";
        }
        return RTW;
    }

    public void setRTW(String RTW)
    {

        this.RTW = RTW;
    }

    public String getMedDue()
    {
        if (medDue == null)
        {
            return "N/A";
        }
        return medDue;
    }

    public void setMedDue(String medDue)
    {

        this.medDue = medDue;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }


}
