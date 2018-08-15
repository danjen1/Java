import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

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

    public static void add(Advisor adv) throws IOException
    {
        advisor_DB.add(adv);
        writeObject();
        System.out.println("Advisor added to the database successfully");

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


    public static void rmv(String name) throws IOException
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

    public void printAll()
    {
        int i = 1;
        for (Advisor item : advisor_DB)
        {
            System.out.print(i + ": ");
            item.print();
            i++;
        }
    }
    public void print(String type)
    {
        int i = 1;
        for (Advisor item : advisor_DB)
        {
            switch (type)
            {
                case "Attendance":
                    for (Attendance thing : item.getAttendance())
                    {
                        System.out.print(i + ".");
                        thing.print();

                    }
                    break;
                case "Goal":
                    for (Goal thing : item.getGoal())
                    {
                        System.out.print(i + ".");
                        thing.print();
                    }
                    break;
                case "Coaching":
                    for (Coaching thing : item.getCoach())
                    {
                        System.out.print(i + ".");
                        thing.print();
                    }
                    break;
            }

        }
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