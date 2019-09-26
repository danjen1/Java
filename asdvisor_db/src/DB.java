import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class DB implements Serializable
{
    private Scanner in = new Scanner(System.in);
    private static ArrayList<Advisor> advisor_DB = new ArrayList<>();
    private String[] cat = {"Attendance", "Goal", "Coaching", "Metrics"};
    private LocalDate date;
    private String head = "****************************************************************************************************************************************************************************";


    public DB() throws IOException, ClassNotFoundException
    //default contstructor
    {
        DB.readObject();
        Nav.menuMaker("main");

    }

    /**********************************************************************
     *                     Records Management                             *
     **********************************************************************/

    public static void add(String name, Advisor adv) throws IOException
    {
        boolean found = false;
        for (Advisor item : advisor_DB)
        {
            if (name.equals(item.getName()))
            {
                found = true;
                System.out.println("Advisor already included in Database. Enter unique Advisor");
                new Advisor();
                break;
            }
        }
        if (!found)
        {
            advisor_DB.add(adv);
            writeObject();
            System.out.println("Advisor " + name + " added to the database successfully");
        }
    }


    public static void add(String name, Attendance attend) throws IOException
    {
        String msg = "Your Attendance Event was added successfully";
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(name))
            {
                System.out.println(name + " found.  Adding Attendance Event ");
                item.getAttendance().add(attend);
                item.getAttendance().sort(Comparator.comparing(Attendance::getDate).reversed());
                writeObject();
                System.out.println(msg);

            }
        }
    }

    public static void add(String name, Goal goal) throws IOException
    {
        String msg = "Your Goal was added successfully";
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(name))
            {
                System.out.println(name + " found.  Adding Goal ");
                item.getGoal().add(goal);
                item.getGoal().sort(Comparator.comparing(Goal::getDate).reversed());
                writeObject();
                System.out.println(msg);
                //item.print();
            }
        }
    }

    public static void add(String name, Coaching coach) throws IOException
    {
        String msg = "Your Coaching Notes were added successfully";
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(name))
            {
                System.out.println(name + " found.  Adding Coaching Notes ");
                item.getCoach().add(coach);
                item.getCoach().sort(Comparator.comparing(Coaching::getDate).reversed());
                writeObject();
                System.out.println(msg);
                //item.print();
            }
        }
    }

    public static void rmvAdv(String name) throws IOException
    {
        for (Advisor item : DB.getAdvisor_DB())
        {
            if (item.getName().equals(name))
            {
                advisor_DB.remove(item);
                System.out.println("Advisor Record: " + name + " removed successfully");
                writeObject();
                break;
            }
            System.out.println("Advisor Not Found");
        }

    }

    public void rmv(String name, String date, String type) throws IOException
    {
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        LocalDate input = LocalDate.parse(date, mdy);
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(name))
            {
                switch (type)
                {
                    case "Attendance":
                        for (Attendance thing : item.getAttendance())
                        {
                            if (thing.getDate().isEqual(input))
                            {

                                System.out.println("Attendance Date Matched");
                                item.getAttendance().remove(thing);
                                writeObject();
                                System.out.println("Attendance Event Dated: " + date + " Removed");
                                break;
                            }
                        }
                        System.out.println(date + ": Attendance Event Not Found");
                        break;
                    case "Goal":
                        for (Goal thing : item.getGoal())
                        {
                            if (thing.getDate().isEqual(input))
                            {
                                item.getGoal().remove(thing);
                                writeObject();
                                System.out.println("Goal Dated: " + date + " Removed");
                                break;
                            }
                        }
                        System.out.println(date + ": Goal Not Found");
                        break;
                    case "Coaching":
                        for (Coaching thing : item.getCoach())
                        {
                            if (thing.getDate().isEqual(input))
                            {
                                item.getCoach().remove(thing);
                                writeObject();
                                System.out.println("Coaching Notes Dated: " + date + " Removed");
                                break;
                            }
                        }
                        System.out.println("Coaching Notes Not Found");
                        break;
                }
                break;
            }
            System.out.println("Advisor Not Found");
            break;

        }

    }

    public void updateAdvInfo(String name) throws IOException
    {
        boolean flag = true;
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yyyy");

        for (Advisor item : advisor_DB)
        {
            if (name.equals(item.getName()))
            {
                item.printAdvInfo(name);
                do
                {
                    System.out.println("Type category name to update: ");
                    String type = in.nextLine();
                    switch (type)
                    {
                        case "Name":
                            System.out.println("Enter Updated Name:");
                            item.setName(in.nextLine());
                            flag = false;
                            break;
                        case "EID":
                            System.out.println("Enter Updated EID:");
                            item.setEID(in.nextLine());
                            flag = false;
                            break;
                        case "Email":
                            System.out.println("Enter Updated Email:");
                            item.setEmail(in.nextLine());
                            flag = false;
                            break;
                        case "DSID":
                            System.out.println("Enter Updated DSID:");
                            item.setDSID(in.nextLine());
                            flag = false;
                            break;
                        case "Status":
                            System.out.println("Enter Updated Status:");
                            item.setStatus(in.nextLine());
                            flag = false;
                            break;
                        case "Shift Type":
                            System.out.println("Enter Updated Shift Type:");
                            item.setShift_type(in.nextLine());
                            flag = false;
                            break;
                        case "Shift":
                            System.out.println("Enter Updated Shift:");
                            item.setShift(in.nextLine());
                            flag = false;
                            break;
                        case "Phone Number":
                            System.out.println("Enter Updated Phone:");
                            item.setPhone(in.nextLine());
                            flag = false;
                            break;
                        case "Time Zone":
                            System.out.println("Enter Updated Time Zone:");
                            item.setT_zone(in.nextLine());
                            flag = false;
                            break;
                        case "bDay":
                            System.out.println("Enter Updated B-Day:");
                            item.setbDay(in.nextLine());
                            flag = false;
                            break;
                        case "Address":
                            System.out.println("Enter Updated Address:");
                            item.setAddress(in.nextLine());
                            flag = false;
                            break;
                        case "Diff":
                            System.out.println("Enter Updated Differential Status: (y)/(n)");
                            String str = in.nextLine();
                            if (str.equals("y") || str.equals("yes") || str.equals("Yes") || str.equals("Y"))
                            {
                                item.setDiff(true);
                            } else
                            {
                                item.setDiff(false);
                            }
                            flag = false;
                            break;
                        case "DOH":
                            System.out.println("Enter Updated Date of Hire:");
                            item.setDOH(LocalDate.parse(in.nextLine(), mdy));
                            flag = false;
                            break;
                        case "RTW":
                            System.out.println("Enter RTW Update:");
                            item.setRTW(in.nextLine());
                            flag = false;
                            break;
                        case "Med Due":
                            System.out.println("Enter Medical Due Update:");
                            item.setMedDue(in.nextLine());
                            flag = false;
                            break;
                    }
                } while (flag);
                writeObject();
                System.out.println("Update Successful");
                break;
            }
            System.out.println("Advisor " + name + " Not Found");
            break;
        }
    }



    /**********************************************************************
     *                     Database Load / Save                           *
     **********************************************************************/

    public static void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("database.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(advisor_DB);
        oos.close();
    }

    public static void readObject() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("database.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            advisor_DB = (ArrayList<Advisor>) ois.readObject();
            System.out.println("Saved Database Loaded");
            ois.close();
        } catch (FileNotFoundException e)
        {
            //JOptionPane.showMessageDialog(null, "You're new here\nLet's get started");
            System.out.println("file not found, saving the database");
            writeObject();
        }

    }


    /***************************
     *     Print Methods       *
     ***************************/
    public static void printMain()
    {
        String head = "****************************************************************************************************************************************************************************";
        DateTimeFormatter mdy = DateTimeFormatter.ofPattern("M/dd/yy");
        String headerT = String.format("%14s%20s%9s%14s%11s%10s%7s%16s%6s%6s%13s", "Advisor", "Status", "Phone", "DSID", "EID", "Type", "Shift", "Diff", "Zone", "DOH", "Address");
        System.out.println(head);
        System.out.println(headerT);
        System.out.println(head);
        int i = 1;
        for (Advisor item : advisor_DB)
        {

            String rowData = String.format(". %-25s%-10s%-15s%-12s%-9s%-6s%-17s%-7s%-6s%-10s%-55s", item.getName(), item.getStatus(), item.getPhone(), item.getDSID(), item.getEID(), item.getShift_type(), item.getShift(), item.getDiff(),
                    item.getT_zone(), item.getDOH().format(mdy), item.getAddress());
            System.out.println(i + rowData);
            i++;

        }
        System.out.println("\nInactive Employees");
        System.out.println(head);
        String headerS = String.format("%14s%20s%14s%11s%13s", "Advisor", "Status", "RTW Date", "Med Due", "Comments");
        System.out.println(headerS);
        System.out.println(head);

        int j = 1;
        for (Advisor item : advisor_DB)
        {
            String rowData = String.format(". %-25s%-12s%-12s%-12s%-50s", item.getName(), item.getStatus(), item.getRTW(), item.getMedDue(), item.getComments());
            if (!item.getStatus().equals("Active"))
            {
                System.out.println(j + rowData);
                j++;
            }
        }

    }

    public static void printEvertything()
    {
        for (Advisor item : advisor_DB)

        {
            item.printAdvInfo(item.getName());
            DB.printAttend(item.getName());
            DB.printCoaching(item.getName());
            DB.printGoals(item.getName());
            DB.printMetrics(item.getName());
        }

    }



    public void printAdv(String adv)
    {
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(adv))
            {
                item.printAdvInfo(adv);

            }
        }
    }
    public  void printAdvAll()
    {
        for (Advisor item : advisor_DB)
        {
            item.printAdvInfo(item.getName());

        }
    }



    public static double[][]  printAttend(String adv)
    {
        double[][] totals = new double[15][5];
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(adv))
            {
                totals = item.getAttendTotals();
                item.printAttendTotals(totals);
                item.printAttendEvents();
                break;

            }
        }
        return totals;
    }

    public static void printCoaching(String adv)
    {
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(adv))
            {
                item.printCoaching();
                break;

            }
        }
    }

    public static void printGoals(String adv)
    {
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(adv))
            {
                item.printGoals();
                break;
            }
        }
    }

    public static void printMetrics(String adv)
    {

    }




    /*
    Getters and Setters
     */
    public static ArrayList<Advisor> getAdvisor_DB()
    {
        return advisor_DB;
    }

    public  void setAdvisor_DB(ArrayList<Advisor> advisor_DB)
    {
        DB.advisor_DB = advisor_DB;
    }

    public String[] getCat()
    {
        return cat;
    }

    public void setCat(String[] cat)
    {
        this.cat = cat;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}