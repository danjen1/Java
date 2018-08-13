import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.Scanner;

public class Program
{
    private Scanner in = new Scanner(System.in);
    String choice;
    Boolean cont = true;


    public Program()
    {

    }

    public int valid(int sel)
    //validates the user input and returns the selection within the accepted range
    {
        boolean test = (sel < 5 && sel > 0);
        while (!test)
        {
            System.out.println("Please select valid range 1-4");
            sel = in.nextInt();
            if (sel > 0 && sel < 5)
            {
                test = true;
                return sel;
            }
        }
        return sel;
    }



    public void exit()
    //exits program when user selects Exit Option
    {
        System.out.println("Good Bye");
        System.exit(0);
    }

    public void home() throws IOException, ClassNotFoundException
    {
        System.out.println("Action Select: ");
        System.out.println("1. Add \t2. Remove \t3. Update \t4. Exit");
        int sel = in.nextInt();
        int temp = valid(sel);
        System.out.println(temp);
        if (temp == 1)
        {
            addMenu();
        } else if (temp == 2)
        {
            rmvMenu();
        } else if (temp == 3)
        {
            updateMenu();
        }
        else if (temp == 4)
        {
            exit();
        }

    }


    public void addMenu() throws IOException, ClassNotFoundException
    {
        System.out.println("Select Option To Add: ");
        System.out.println("1. Advisor \t2. Attendance \t3. Goals \t4. Main Menu");
        int sel = in.nextInt();
        in.nextLine();
        int temp = valid(sel);
        if (temp == 1)
        {
            DB db = new DB();


        } else if (temp == 2)
        {
            Attend newAttend = new Attend();
        } else if (temp == 3)
        {
            Goals newGOal = new Goals();
        } else if (temp == 4)
        {
            home();
        }
    }

    private void rmvMenu()
    {
        System.out.println("You made it to Remove Menu");
    }


    private void updateMenu()
    {
        System.out.println("You Made it to Update Menu");

    }

}

