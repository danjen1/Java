import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Program
{
    private Scanner in = new Scanner(System.in);


    public Program()
    {

    }

    /*public int valid(int sel)
    {
        return sel;
    }
    */

    /*
    Making the Menus
     */
    public static void homeMenu()
    {
        Scanner in = new Scanner(System.in);
        String str;
        int i = 0;
        System.out.println("Home - Select an Action: ");
        System.out.println("1. Add \t2. Remove \t3. Update \t4. Reports \t5. Exit");

    }

    public static void addMenu()
    {
        Scanner in = new Scanner(System.in);
        int i = 0;
        System.out.println("Add Menu - Select Option To Add: ");
        System.out.println("1. Advisor \t2. Attendance \t3. Goals \t4. Main Menu");
    }

    public static void rmvMenu()
    {
        Scanner in = new Scanner(System.in);
        int i = 0;
        System.out.println("Remove Menu - Select Option To Remove: ");
        System.out.println("1. Advisor \t2. Attendance \t3. Goals \t4. Main Menu");
    }

    public void menus(String cl) throws IOException
    {
        Scanner in = new Scanner(System.in);
        String str;
        int i = 0;
        switch (cl)
        {
            case "home":
                homeMenu();
                i = in.nextInt();
                valid(i, "home");
                switch (i)
                {
                    case 1: //Add Menu
                        addMenu();
                        i = in.nextInt();
                        in.nextLine();
                        valid(i, "addMenu");
                        switch (i)
                        {
                            case 1:
                                do
                                {
                                    Advisor temp = new Advisor("1234", "JOey", "1345", "1235");
                                    System.out.println("Joey Added");
                                    System.out.println("\nWould you like to add another Advior? (Y)/(N)");
                                    str = in.nextLine();
                                    valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 2:
                                do
                                {
                                    System.out.println("Attend Added");
                                    System.out.println("\nWould you like to add another Attendance Event? (Y)/(N)");
                                    str = in.nextLine();
                                    valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 3:
                                do
                                {
                                    Goals temp = new Goals();
                                    System.out.println("Attend Added");
                                    System.out.println("\nWould you like to add another Goal? (Y)/(N)");
                                    str = in.nextLine();
                                    valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 4:
                                menus("home");
                        }
                    case 2 :
                        rmvMenu();
                        i = in.nextInt();
                        in.nextLine();
                        i = valid(i, "rmvMenu");
                        switch (i)
                        {
                            case 1:
                                do
                                {

                                    System.out.println("Advisor to Delete: ");
                                    str = in.nextLine();
                                    DB.delAdv(str);
                                    System.out.println("\nWould you like to remove another Advior? (Y)/(N)");
                                    str = in.nextLine();
                                    str = valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 2:
                                do
                                {
                                    System.out.println("Advisor to Modify: ");
                                    str = in.nextLine();
                                    System.out.println("Date to Delete");
                                    String date = in.nextLine();
                                    DB.delAtt(str, date);
                                    System.out.println("\nWould you like to remove another Attendance Event? (Y)/(N)");
                                    str = in.nextLine();
                                    str = valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 3:
                                do
                                {
                                    System.out.println("Attend Added");
                                    System.out.println("\nWould you like to add another Goal? (Y)/(N)");
                                    str = in.nextLine();
                                    valid(str);
                                } while (str.equals("y"));
                                menus("home");
                            case 4:
                                menus("home");
                        }



                        }
                }

        }




    /*
     Menu Input Validation, ensures 1 - Max and String "Y/N" variants to navigate the menu
     */
    private int valid(int sel, String cl)
    //validates user menu input within accepted range
    {
        int max = 0;
        switch (cl)
        {
            case "home":
                max = 5;
                break;
            case "rmvMenu":
            case "goals":
            case "addMenu":
                max = 4;
                break;
            default:
        }
        if (sel > 0 && sel <= max)
        {
            return sel;
        }
        do
        {
            System.out.println("Please select valid range 1-" + max);
            sel = in.nextInt();
        } while (sel < 0 || sel >= max + 1);
        System.out.println(sel);
        return sel;
    }


    private String valid(String sel)

    //validates the user input and returns the selection within the accepted range
    {
        switch (sel)
        {
            case "Yes":
            case "y":
            case "YES":
            case "yes":
            case "Y":
            case "YEs":
            case "yES":
            case "yeS":
                sel = "y";
                return sel;
            case "No":
            case "n":
            case "NO":
            case "no":
            case "nO":
                sel = "n";
                return sel;
            default:
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

        System.out.print("Action Select: ");
        System.out.println("1. Add \t2. Remove \t3. Update \t4. Reports \t5. Exit");
        int sel = parseInt(in.nextLine());
        in.nextLine();
        int temp = valid(sel, "home");
        System.out.println(temp);
        switch (temp)
        {

        }

        /*  if (temp == 1)
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
        */
    }


    /* public void addMenu() throws IOException, ClassNotFoundException
     {

         int sel = in.nextInt();
         in.nextLine();
         int temp = valid(sel, "addMenu");
         if (temp == 1)
         {
             Advisor newAdv = new Advisor();
             System.out.println("\nWould you like to add another Advior? (Y/N)");
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
     */



    private void updateMenu()
    {
        System.out.println("You Made it to Update Menu");

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();
        DB.readObject();



    }

}

