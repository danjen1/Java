import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.util.Scanner;

public class Program
{

    /*
    methods needed:
    interface:
    add / remove / update / reports / exit
    Advisor Attendance Goals Main Menu

    validation:
    test for valid input loop "please enter valid selection" if invliad #s or letters

    add / remove method same method written for each object Advisor / Attend / Goals
    loop would you like to add / remove / update more Objects / know the difference
     */

    Scanner in = new Scanner(System.in);


    public Program()
    {

    }

    public int valNum(int sel)
    //validates the user input and returns the selection within the accepted range
    {
        boolean test = (sel < 6 && sel > 0);
        while (!test)
        {
            System.out.println("Please select valid range 1-5");
            sel = in.nextInt();
            if (sel > 0 && sel < 6)
            {
                test = true;
                return sel;
            }
        }
        return sel;

    }

    /*
    public String valLet(String sel)

    //validates the user input and returns the selection within the accepted range
    {
        boolean test = (!sel.equals("Yes") ||!sel.equals("Y") || (!sel.equals("y") || (!sel.equals("YES") || (!sel.equals("yes")))));
        while (!test)
        {
            System.out.println("Please select Yes or No");
            sel = in.nextLine();
            if (sel.equals("Yes") ||sel.equals("Y") || sel.equals("y") || sel.equals("YES") || sel.equals("yes"))
            {
                test = true;
                return sel;
            }
        }
        return sel

    }
*/


    public void exit()
    //exits program when user selects Exit Option
    {
        System.out.println("Good Bye");
        System.exit(0);
    }

    public void home() throws IOException, ClassNotFoundException
    {
        System.out.println("Action Select: ");
        System.out.println("1. Add \n2. Remove \n3. Update \n4. Reports \n5. Exit");
        int sel = in.nextInt();
        int temp = valNum(sel);
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

        }
        else if (temp == 5)
        {
            exit();
        }

    }


    public void addMenu() throws IOException, ClassNotFoundException
    {
        System.out.println("Select Option To Add: ");
        System.out.println("1. Advisor \n2. Attendance \n3. Goals \n\n4. Main Menu");
        int sel = in.nextInt();
        in.nextLine();
        int temp = valNum(sel);
        if (temp == 1)
        {
            Advisor newAdv = new Advisor();
            System.out.println("Would you like to add another Advior? (Y/N)");
            String selLet = in.nextLine();
            if (selLet.equals("Y") || selLet.equals("Yes") || selLet.equals("YES") || selLet.equals("yes") || selLet.endsWith("y"))
            {
                Advisor tempAdv = new Advisor();
            } else
            {
                home();
            }



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

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();
        DB.readObject();
        DB.printAll();

    }

}

