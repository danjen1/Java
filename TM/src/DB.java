import java.io.*;
import java.util.*;

public class DB implements Serializable
{

    public static ArrayList<Advisor> advDB = new ArrayList<>();

    /**********************
     * File Input / Output*
     **********************/
    public static void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream("database.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(advDB);
        oos.close();
    }

    public void readObject() throws IOException, ClassNotFoundException
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream("database.ser");
        } catch (FileNotFoundException e)
        {
            // JOptionPane.showMessageDialog(null, "You're new here\nLet's get started");
            writeObject();
        }
        ObjectInputStream ois = new ObjectInputStream(fis);
        advDB = (ArrayList<Advisor>) ois.readObject();
        // JOptionPane.showMessageDialog(null, "Saved Database Loaded");
        ois.close();
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
        adv.print();
        System.out.println();
        DB.writeObject();
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
        writeObject();
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
        writeObject();
    }


    public static void add(String adv, Coaching coaching) throws IOException
    {
        String msg = "Your Coaching Comment was added successfully";
        for (Advisor item : advDB)
        {
            if (item.getName().equals(adv))
            {
                System.out.println(adv + " found.  Adding Coachingn Comment");
                item.getCoaching().add(coaching);
                System.out.println(msg);
            }
        }
        writeObject();
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
                writeObject();
                return;
            }
        }
        System.out.println("Advisor Not Found");
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
                            if (things.getDate().equals(date))
                            {
                                System.out.print("Removing: " + type + " " + things.getDate() + " " + things.getType() + " " + things.getHours() + " " + things.getComments()
                                        + " " + things.getSubmitted());
                                item.getAttendance().remove(things);
                                break;
                            }
                        }
                    case "Goal":
                        for (Goal things : item.getGoal())
                        {
                            if (things.getDate().equals(date))
                            {
                                System.out.print("Removing: " + type + " " + things.getDate() + " " + things.getName()); //+ " " + things.getHours() + " " + things.getComments() + " " + things.getSubmitted());
                                item.getGoal().remove(things);
                                break;
                            }
                        }
                    case "Coaching":
                        for (Coaching things : item.getCoaching())
                        {
                            if (things.getDate().equals(date))
                            {
                                System.out.print("Removing: " + type + " " + things.getDate() + " " + things.getName()); //+ " " + things.getHours() + " " + things.getComments() + " " + things.getSubmitted());
                                item.getCoaching().remove(things);
                                break;
                            }
                        }
                }
            }

            System.out.println(type + " Not Found");
        }
        System.out.println("Advisor Not Found");
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