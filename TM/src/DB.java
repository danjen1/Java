import java.io.*;
import java.util.*;

public class DB implements Serializable
{
    private String file = "database.ser";
    private static ArrayList<Advisor> db = new ArrayList<>();

    /**********************
     * File Input / Output*
     **********************/
    public void writeObject() throws IOException
    {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(db);
        oos.close();
    }

    public void readObject() throws IOException, ClassNotFoundException
    {
        new File("path/to/file.txt").isFile();
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        db = (ArrayList<Advisor>) ois.readObject();
        ois.close();
    }

    /***************************************************
     *Advisor Objects methods adding / deleting records*
     ***************************************************/
    public void addAdv()
    {
        Advisor newAdv = new Advisor();
        db.add(newAdv);
        System.out.println("You added");
        newAdv.printAll();
    }

    private static void delAdv(String name)
    {
        for (Advisor item : db)
        {
            if (item.getName().equals(name))
            {
                System.out.print("Removing: ");
                item.printAll();
                db.remove(item);
                return;
            }
        }
    }























   /*****************************************************************
    *Attendance Array methods adding / deleting and printing records*
    *****************************************************************/
    private static void addAtt(String advisor, String date, String type, double hours, String comments, Boolean submitted)
    {
        Attend temp = new Attend(advisor, date, type, hours, comments, submitted);
        for (Advisor item : db)
        {
            if (item.getName().equals(advisor))
            {
                item.getAttend().add(temp);
            }
        }
    }

    private static void delAtt(String name, String date)
    {
        for (Advisor item : db)
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

    private static void printAtt()
    {
        for (Advisor item : db)
        {
            System.out.println("Advisor Attendance " + item.getName() + ":");
            for (Attend items : item.getAttend())
                items.print();
        }
    }


    public static ArrayList<Advisor> getDb()
    {
        return db;
    }

    public static void setDb(ArrayList<Advisor> db)
    {
        DB.db = db;
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
