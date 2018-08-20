import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class DB implements Serializable
{
    private static ArrayList<Advisor> advisor_DB = new ArrayList<>();
    private String[] cat = {"Attendance", "Goal", "Coaching", "Metrics"};
    private LocalDate date;


    public DB() throws IOException, ClassNotFoundException
    //default contstructor
    {
        DB.readObject();

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
                            System.out.println(date + ": Attendance Event Not Found");

                        }
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