import javax.swing.*;
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
            Program one = new Program();
            one.home();
        }
        ObjectInputStream ois = new ObjectInputStream(fis);
        advDB = (ArrayList<Advisor>) ois.readObject();
       // JOptionPane.showMessageDialog(null, "Saved Database Loaded");
        ois.close();
        Program one = new Program();
        one.home();
    }

    /***************************************************
     *Advisor Objects print / adding / deleting records*
     ***************************************************/





    /***************************
     *Adding / Deleting Records*
     ***************************/
    /*
    Advisor Records
     */
    public static void addAdv(Advisor adv) throws IOException
    {
        advDB.add(adv);
        System.out.println("Your Advisor was added succesfully: \n");
        adv.print();
        System.out.println();
        DB.writeObject();

    }

    public void delAdv(String name)
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
        }
    }

    /*
    Attendance Records
     */
    private static void addAtt(String advisor, String date, String type, double hours, String comments, Boolean submitted)
    {
        Attend temp = new Attend(advisor, date, type, hours, comments, submitted);
        for (Advisor item : advDB)
        {
            if (item.getName().equals(advisor))
            {
                item.getAttend().add(temp);
            }
        }
    }

    private static void delAtt(String name, String date)
    {
        for (Advisor item : advDB)
        {
            if (item.getName().equals(name))
            {
                for (Attend things : item.getAttend())
                {
                    if (things.getDate().equals(date))
                    {
                        System.out.print("Removing: " + things.getDate() + " " + things.getType() + " " + things.getHours() + " " + things.getComments()
                                + " " + things.getSubmitted());
                        item.getAttend().remove(things);
                        return;
                    }
                }
            }
        }
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
    public static ArrayList<Advisor> getDb()
    {
        return advDB;
    }

    public static void setDb(ArrayList<Advisor> db)
    {
        DB.advDB = db;
    }






    /* Main Method Testing */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

    }














    /*
    public static void main(String[] args)
    {
        add("001", "IG", "Horowitz", "Horowitz@protonmail.com", 36, 91.91, 92.92, 93.93, 94.94, 75.75);
        add("002", "Rod", "Rosenstein", "rod_roddy@icloud.com", 37, 98.78, 89.98, 93.45, 99.89, 100);
        add("003", "Jeff", "Sessions", "who_knows @icloud.com", 10, 100, 89.75, 95.85, 99.89, 100);

        printAll();
        print_average_grade("001");
        print_average_grade("002");
        print_average_grade("003");
        print_invalid_emails();

    }

    private static void remove(String ID)
    {
        for (Advisor item : roster)
        {
            if (ID.equals(item.getID()))
            {
                roster.remove(item);
                return;
            }
        }
        System.out.println("Advisor not found, no ID match");
    }
    private static void printAll()
    {
        for (Advisor item : roster)
        {
            item.print();
        }
        System.out.println();
    }


    /*
    private static void print_average_grade(String ID)

    {
        for (Advisor item : roster)
        {

            if (ID.equals(item.getID()))
            {
                double total = 0;
                for (double grade : item.getGrades())
                {
                    total += grade;
                }
                total = total / item.getGrades().length;
                System.out.print("Advisor ID " + item.getID() + ": average of " + item.getGrades().length + " grades for " + item.getFirstName() + " is: ");
                System.out.printf("%.2f", total);
                System.out.println("\n");
                return;
            }
        }
        System.out.println("Advisor ID not found");
        System.out.println();

    }

    private static void print_invalid_emails()
    {
        for (Advisor item : roster)
        {
            if (!(item.getEmail().contains("@")) || (item.getEmail().contains(" ") || (!(item.getEmail().contains(".")))))
            {
                System.out.println("Advisor " + item.getFirstName() + " email is invalid: " + item.getEmail());
                System.out.println();
                return;
            }

        }
        System.out.println("All eMails are correct");
        System.out.println();
    }
    */
}
