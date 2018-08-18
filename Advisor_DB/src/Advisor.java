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

    private String head = "***********************************************************************";

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
        LocalDate today = LocalDate.now();
        LocalDate thirty = today.minusDays(30);
        LocalDate sixty = today.minusDays(60);
        LocalDate ninety = today.minusDays(90);
        LocalDate oneEighty = today.minusDays(180);
        double[][] totals = new double[9][5];
        double[] fd = new double[5];
        double[] pd = new double[5];
        double[] kc = new double[5];
        double[] hd = new double[5];
        double[] ad = new double[5];
        double[] il = new double[5];
        double[] lo = new double[5];
        double[] vac = new double[5];



        for (Attendance item : getAttendance())
        {
            double sum30 = 0, sum60 = 0, sum90 = 0, sum180 = 0, sumTotal = 0;

            if (item.getType().equals("Full Day"))
            {

                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println("sum 30 runs");
                    System.out.println(sum30);
                }
                if (item.getDate().isBefore(thirty) && item.getDate().isAfter(sixty))
                {
                    System.out.println("sum 60 runs");
                    sum60 += item.getHours();
                }
                if (item.getDate().isAfter(ninety) && item.getDate().isBefore(sixty))
                {
                    System.out.println("sum 90 runs");
                    sum90 += item.getHours();
                }
                if (item.getDate().isAfter(oneEighty) && item.getDate().isBefore(ninety))
                {
                    System.out.println("sum 180 runs");
                    sum180 += item.getHours();
                }
                sumTotal = sum30 + sum60 + sum90 + sum180;
                fd[0] += sum30;
                fd[1] += sum60;
                fd[2] += sum90;
                fd[3] += sum180;
                fd[4] += sumTotal;
            }
            if (item.getType().equals("Partial Day"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                pd[0] += sum30;
                pd[1] += sum60;
                pd[2] += sum90;
                pd[3] += sum180;
                pd[4] += sumTotal;
            }
            if (item.getType().equals("KinCare"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                kc[0] += sum30;
                kc[1] += sum60;
                kc[2] += sum90;
                kc[3] += sum180;
                kc[4] += sumTotal;
            }
            if (item.getType().equals("HomeDT"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                hd[0] += sum30;
                hd[1] += sum60;
                hd[2] += sum90;
                hd[3] += sum180;
                hd[4] += sumTotal;
            }
            if (item.getType().equals("AppleDT"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                ad[0] += sum30;
                ad[1] += sum60;
                ad[2] += sum90;
                ad[3] += sum180;
                ad[4] += sumTotal;
            }
            if (item.getType().equals("iLOA"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                il[0] += sum30;
                il[1] += sum60;
                il[2] += sum90;
                il[3] += sum180;
                il[4] += sumTotal;
            }
            if (item.getType().equals("LOA"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                lo[0] += sum30;
                lo[1] += sum60;
                lo[2] += sum90;
                lo[3] += sum180;
                lo[4] += sumTotal;
            }
            if (item.getType().equals("Vacation"))
            {
                if (item.getDate().isAfter(thirty) && item.getDate().isBefore(today))
                {
                    sum30 += item.getHours();
                    System.out.println(sum30);
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
                vac[0] += sum30;
                vac[1] += sum60;
                vac[2] += sum90;
                vac[3] += sum180;
                vac[4] += sumTotal;
            }

        }
        totals[0][0] = fd[0];
        totals[0][1] = fd[1];
        totals[0][2] = fd[2];
        totals[0][3] = fd[3];
        totals[0][4] = fd[4];
        totals[1][0] = pd[0];
        totals[1][1] = pd[1];
        totals[1][2] = pd[2];
        totals[1][3] = pd[3];
        totals[1][4] = pd[4];
        totals[2][0] = kc[0];
        totals[2][1] = kc[1];
        totals[2][2] = kc[2];
        totals[2][3] = kc[3];
        totals[2][4] = kc[4];
        totals[3][0] = hd[0];
        totals[3][1] = hd[1];
        totals[3][2] = hd[2];
        totals[3][3] = hd[3];
        totals[3][4] = hd[4];
        totals[4][0] = ad[0];
        totals[4][1] = ad[1];
        totals[4][2] = ad[2];
        totals[4][3] = ad[3];
        totals[4][4] = ad[4];
        totals[5][0] = il[0];
        totals[5][1] = il[1];
        totals[5][2] = il[2];
        totals[5][3] = il[3];
        totals[5][4] = il[4];
        totals[6][0] = lo[0];
        totals[6][1] = lo[1];
        totals[6][2] = lo[2];
        totals[6][3] = lo[3];
        totals[6][4] = lo[4];
        totals[7][0] = vac[0];
        totals[7][1] = vac[1];
        totals[7][2] = vac[2];
        totals[7][3] = vac[3];
        totals[7][4] = vac[4];
        totals[8][0] = totals[0][0] + totals[1][0] + totals[2][0] + totals[3][0] + totals[4][0] +  totals[5][0] + totals[6][0] + totals[7][0];
        totals[8][1] = totals[0][1] + totals[1][1] + totals[2][1] + totals[3][1] + totals[4][1] +  totals[5][1] + totals[6][1] + totals[7][1];
        totals[8][2] = totals[0][2] + totals[1][2] + totals[2][2] + totals[3][2] + totals[4][2] +  totals[5][2] + totals[6][2] + totals[7][2];
        totals[8][3] = totals[0][3] + totals[1][3] + totals[2][3] + totals[3][3] + totals[4][3] +  totals[5][3] + totals[6][3] + totals[7][3];
        totals[8][4] = totals[0][4] + totals[1][4] + totals[2][4] + totals[3][4] + totals[4][4] +  totals[5][4] + totals[6][4] + totals[7][4];

        return totals;
    }





    /***************************
     *     Print Methods       *
     ***************************/

    public void printAttendTotals(double[][] totals)
    {
        String fd = "Full Day:";
        String eoLI = "Partial Day:";
        String hDT = "HomeDT:";
        String aDT = "AppleDT:";
        String iLOA = "iLOA:";
        String LOA = "LOA:";
        String kinCare = "KinCare:";
        String vac = "Vacation:";
        String total = "Totals:";
        String headerT = String.format("%22s%9s%9s%9s%9s", "30 Days", "60 Days", "90 Days", "180 Days", "Annual");
        String fdRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", fd, totals[0][0], totals[0][1], totals[0][2], totals[0][3], totals[0][4]);
        String eoliRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", eoLI, totals[1][0], totals[1][1], totals[1][2], totals[1][3], totals[1][4]);
        String kinRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", kinCare, totals[2][0], totals[2][1], totals[2][2], totals[2][3], totals[2][4]);
        String hDTRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", hDT, totals[3][0], totals[3][1], totals[3][2], totals[3][3], totals[3][4]);
        String aDTRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", aDT, totals[4][0], totals[4][1], totals[4][2], totals[4][3], totals[4][4]);
        String iLOARow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", iLOA, totals[5][0], totals[5][1], totals[5][2], totals[5][3], totals[5][4]);
        String LOARow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", LOA, totals[6][0], totals[6][1], totals[6][2], totals[6][3], totals[6][4]);
        String vacRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", vac, totals[7][0], totals[7][1], totals[7][2], totals[7][3], totals[7][4]);
        String totRow = String.format("%-15s%5.2f%9.2f%9.2f%9.2f%10.2f", total, totals[8][0], totals[8][1], totals[8][2], totals[8][3], totals[8][4]);
        System.out.println("\nAttendance Totals: " + getName());
        System.out.println("***********************************************************************");
        System.out.println(headerT);
        System.out.println("***********************************************************************");
        System.out.println(fdRow);
        System.out.println(eoliRow );
        System.out.println(kinRow);
        System.out.println(hDTRow);
        System.out.println(aDTRow);
        System.out.println(iLOARow);
        System.out.println(LOARow);
        System.out.println(vacRow);
        System.out.println("***********************************************************************");
        System.out.println(totRow);
        System.out.println();

    }

    public void printAdvInfo(String adv)
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");
        System.out.println("\n" + head);
        System.out.println("Advisor Information: " + getName());
        System.out.println(head);
        System.out.println("EID: " + getEID() + "\nEmail: " + getEmail() + "\nPhone Number: " + getPhone() + "\nStatus: " + getStatus() +
                "\nShift Type: " + getShift_type() + "\nShift: " + getShift() + "\nDiff: " + getDiff() + "\nTime Zone: " + getT_zone() +
                "\nDOH: " + getDOH().format(mdy) + "\nbDay: " + getbDay() + "\nAddress: " + getAddress() + "\n");
    }

    public void printAttendEvents()
    {
        int i = 1;
        System.out.println("\n" + getName() + " Attendance:");
        String headerT = String.format("%10s%12s%13s%13s", "Date", "Type", "Hours", "Comments");
        System.out.println("***********************************************************************");
        System.out.println(headerT);
        System.out.println("***********************************************************************");
        for (Attendance item : getAttendance())

        {
            System.out.print(i);
            item.print();
            i++;
        }
    }

    public void printCoaching ()
    {

    }
    public void printCoachingSumm ()
    {

    }
    public void printGoals ()
    {

    }
    public void printGoalSumm ()
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


}
