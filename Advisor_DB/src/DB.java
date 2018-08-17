import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DB implements Serializable
{
    private static ArrayList<Advisor> advisor_DB = new ArrayList<>();


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
                System.out.println(msg);
                //item.print();
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
                System.out.println(msg);
                //item.print();
            }
        }
    }


    public  void rmv(String name) throws IOException
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

    public void rmv(String name, String date, String type)
    {
        for (Advisor item : advisor_DB)
        {
            if (item.getName().equals(name))
            {
                switch (type)
                {
                    case "Attendance":
                        for (Attendance thing : item.getAttendance())
                        {
                            if (thing.getDate().equals(date))
                            {
                                System.out.println("Attendance Date Matched");
                                item.getAttendance().remove(thing);
                                System.out.println("Attendance Event Dated: " + date + " Removed");
                                break;
                            }
                            System.out.println(date + ": Attendance Event Not Found");
                        }
                        break;
                    case "Goal":
                        for (Goal thing : item.getGoal())
                        {
                            if (thing.getDate().equals(date))
                            {
                                item.getGoal().remove(thing);
                                System.out.println("Goal Dated: " + date + " Removed");
                                break;
                            }
                            System.out.println(date + ": Goal Not Found");

                        }
                        break;
                    case "Coaching":
                        for (Coaching thing : item.getCoach())
                        {
                            if (thing.getDate().equals(date))
                            {
                                item.getCoach().remove(thing);
                                System.out.println("Coaching Notes Dated: " + date + " Removed");
                                break;
                            }
                            System.out.println("Coaching Notes Not Found");
                        }
                }
                break;
            }
            System.out.println("Advisor Not Found");
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
    public void print(String type)
    {
        for (Advisor item : advisor_DB)
        {
            switch (type)
            {
                case "Attendance":
                    for (Attendance thing : item.getAttendance())
                    {
                        int i = 1;
                        System.out.print(i + ". Attendance Comments: ");
                        //thing.print();
                        i++;
                        break;
                    }
                    break;
                case "Goal":
                    for (Goal thing : item.getGoal())
                    {
                        int i = 1;
                        System.out.print(i + ". Goal Comments: ");
                        thing.print();
                        i++;
                        break;
                    }
                    break;
                case "Coaching":
                    for (Coaching thing : item.getCoach())
                    {
                        int i = 1;
                        System.out.print(i + ". Coaching Comments: ");
                        thing.print();
                        i++;
                        break;
                    }
                    System.out.println();
                case "All":
                    int i = 1;
                    System.out.println("Advisor Information");

                {
                    for (int j = 0; j < 50; j++)
                    {
                        System.out.print("-");
                    }
                    System.out.println("\n" + i + ". Advisor: " + item.getName() + " ");
                    for (int j = 0; j < 50; j++)
                    {
                        System.out.print("-");
                    }
                    System.out.println();
                    item.print();
                    i++;
                }
            }
        }
    }

    public double[] printattendCats(String type)
    {
        double[] catTotals = new double[9];
        double fullDay = 0, eoLI = 0, vac = 0, hDT = 0, aDT = 0, iLOA = 0, LOA = 0, kinCare = 0, total = 0;

        for (Advisor thing : advisor_DB)
        {
            for (Attendance item : thing.getAttendance())
            {
                switch (type)
                {
                    case "Full Day":
                        if (item.getType().equals("Full Day"))
                        {
                            catTotals[0] = fullDay;
                        }
                    case "Early Out / Late In":
                        if (item.getType().equals("Early Out / Late In"))
                        {
                            eoLI += item.getHours();
                        }
                    case "Vacation":
                        if (item.getType().equals("Vacation"))
                        {
                            vac += item.getHours();
                        }
                    case "Home DT":
                        if (item.getType().equals("Home DT"))
                        {
                            hDT += item.getHours();
                        }
                    case "Apple DT":
                        if (item.getType().equals("Full Day"))
                        {
                            aDT += item.getHours();
                        }
                    case "iLOA":
                        if (item.getType().equals("iLOA"))
                        {
                            iLOA += item.getHours();
                        }
                    case "LOA":
                        if (item.getType().equals("LOA"))
                        {
                            LOA += item.getHours();
                        }
                    case "KinCare":
                        if (item.getType().equals("KinCare"))
                        {
                            kinCare += item.getHours();
                        }
                    case "All":
                        total += item.getHours();
                        item.print(catTotals);
                }
            }
        }
        return catTotals;
    }





    /*
    Getters and Setters
     */
    public static ArrayList<Advisor> getAdvisor_DB()
    {
        return advisor_DB;
    }

    public static void setAdvisor_DB(ArrayList<Advisor> advisor_DB)
    {
        DB.advisor_DB = advisor_DB;
    }
}