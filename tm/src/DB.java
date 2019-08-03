import javax.swing.*;
import java.io.*;
import java.util.*;
import java.io.*;

public class DB implements Serializable
{

    public static ArrayList<Advisor> advDB = new ArrayList<>();

    public DB() throws IOException, ClassNotFoundException
    {
        readObject();
    }
    /**********************************************************************
     *                     Database Load / Save                           *
     **********************************************************************/

    public static void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("database.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(advDB);
        oos.close();
    }

    public static void readObject() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("database.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            advDB = (ArrayList<Advisor>) ois.readObject();
            System.out.println("Saved Database Loade");
            ois.close();
        } catch (FileNotFoundException e)
        {
            //JOptionPane.showMessageDialog(null, "You're new here\nLet's get started");
            System.out.println("file not found, saving the database");
            writeObject();
        }


    /***************************
     *Adding / Deleting Records*
     ***************************/
    /*
    Advisor Records
     */
    public static void add(Advisor adv) throws IOException
    {
        String msg = "Your Advisor was added succesfully: \n";
        advDB.add(adv);
        System.out.println(msg);
        //adv.print();
        System.out.println();
    }

    public static void add(String adv, Attendance attendance) throws IOException
    {
        String msg = "Your Attendance Event was added successfully";
        for (Advisor item : advDB)
        {
            if (item.getName().equals(adv))
            {
                System.out.println(adv + " found.  Adding Attendance Event");
                item.getAttendance().add(attendance);
                System.out.println(msg);
            }
        }
    }

    public static void add(String adv, Goal goal) throws IOException
    {
        String msg = "Your Goal was added successfully";
        for (Advisor item : advDB)
        {
            if (item.getName().equals(adv))
            {
                System.out.println(adv + " found.  Adding Goal");
                item.getGoal().add(goal);
                System.out.println(msg);
            }
        }
    }


    public static void add(String adv, Coaching coaching) throws IOException
    {
        String msg = "Your Coaching Comment was added successfully";
        for (Advisor item : advDB)
        {
            if (item.getName().equals(adv))
            {
                System.out.println(adv + " found.  Adding Coaching Comment");
                item.getCoaching().add(coaching);
                System.out.println(msg);
            }
        }
    }

    public static void del(String name) throws IOException
    {
        for (Advisor item : advDB)
        {
            if (item.getName().equals(name))
            {
                System.out.print("Removing: ");
                item.print();
                advDB.remove(item);
                return;
            }
            System.out.println("Advisor Not Found");
        }
    }

    public static void del(String name, String date, String type) throws IOException
    {

        for (Advisor item : advDB)
        {
            if (item.getName().equals(name))
            {
                switch (type)
                {
                    case "Attendance":
                        for (Attendance things : item.getAttendance())
                        {
                            if (things.getDate().equals(date) && things.getName().equals(item.getName()))
                            {
                                System.out.println("Removing: " + type + " " + things.getDate() + " " + things.getType() + " " + things.getHours() + " " + things.getComments()
                                        + " " + things.getSubmitted());
                                item.getAttendance().remove(things);
                                break;

                            }
                            System.out.println("Attendandce Not Found");
                        }
                    case "Goal":
                        for (Goal things : item.getGoal())
                        {
                            if (things.getDate().equals(date) && things.getName().equals(item.getName()))
                            {
                                System.out.println("Removing: " + type + " " + things.getDate() + " " + things.getName()); //+ " " + things.getHours() + " " + things.getComments() + " " + things.getSubmitted());
                                item.getGoal().remove(things);
                                break;
                            }
                            System.out.println("Goal Not Found1");

                        }
                    case "Coaching":
                        for (Coaching things : item.getCoaching())
                        {
                            if (things.getDate().equals(date) && things.getName().equals(item.getName()))
                            {
                                System.out.println("Removing: " + type + " " + things.getDate() + " " + things.getName()); //+ " " + things.getHours() + " " + things.getComments() + " " + things.getSubmitted());
                                item.getCoaching().remove(things);
                                break;
                            }
                            System.out.println("Cocahing Not Found");

                        }

                }
                break;
            }
            System.out.println("Advisor Not Found");
        }

    }

    public void save() throws IOException
    {
        writeObject();
    }


    /***************************
     *     Print Methods       *
     ***************************/

    public void printAll()
    {
        int i = 1;
        for (Advisor item : advDB)
        {
            System.out.print(i + ": ");
            item.print();
            i++;
        }
    }




      /*
    Getters and Setters
     */

    public static ArrayList<Advisor> getAdvDB()
    {
        return advDB;
    }

    public static void setAdvDB(ArrayList<Advisor> advDB)
    {
        DB.advDB = advDB;
    }
}