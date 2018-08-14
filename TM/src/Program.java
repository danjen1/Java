import java.io.IOException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Program
{
    private static Scanner in = new Scanner(System.in);
    private static String str;



    public Program()
    {

    }


    public static void add(String type) throws IOException
    {

        String cont = "Would you like to add more " + type + " Records? (Y)/(N)";

        switch(type)
        {
            case "Advisor" :
                new Advisor("1234", "Joey", "1345", "1235");
                break;
            case "Attendance":
                new Attendance("Daniel Jenkins", "8/14", "LOA", 4.5, "Comments", true);
                break;
            case "Goal":
                new Goal();
                break;
            case "Coaching":
                new Coaching();
                break;
        }
        do
        {
            System.out.println(cont);
            str = valid(in.nextLine());
        } while (!str.equals("n"));
        System.out.println();
        System.out.println();
        nav("home");
    }


    /*
    REMOVE MENUS / METHODS
     */

    public static void rm(String type) throws IOException
    {
        String rmvd = type + " Removed";
        String cont = "Would you like to remove more " + type + " Records? (Y)/(N)";
        String name;
        String date;
        switch(type)
        {
            case "Advisor" :
                System.out.println("Remove Advisor (First Last): ");
                name = in.nextLine();
                DB.del(name);
                break;
            case "Attendance":
                System.out.println("Remove Attendance for Advisor: ");
                name = in.nextLine();
                System.out.println("Date of Attendance Event to Remove:");
                date = in.nextLine();
                DB.del(name, date, type);
                break;
            case "Goal":
                new Goal();
                break;
            case "Coaching":
                new Coaching();
                break;
        }
        do
        {
            System.out.println(type +  " " + rmvd);
            System.out.println(cont);
            str = valid(in.nextLine());
            add(type);
        } while (str.equals("y"));
        nav("home");
    }



    public static int makeMenu(String menu)
    {
        int i;
        String select = " - Select an item: ";
        String option1 = "1. Add \t2. Remove \t3. Update \t4. Reports \t5. Exit";
        String option2 = "1. Advisor \t2. Attendance \t3. Goal \t4. Coaching \t5. Main Menu";

        switch (menu)
        {
            case "home":
                str = "Home";
                System.out.println(str + select);
                System.out.println(option1);
                break;
            case "addMenu":
                str = "Add";
                System.out.println(str + select);
                System.out.println(option2);
                break;
            case "rmvMenu":
                str = "Remove";
                System.out.println(str + select);
                System.out.println(option2);
                break;
            case "upMenu":
                str = "Update";
                System.out.println(str + select);
                System.out.println(option2);
                break;
            case "reports":
                str = "Reports";
                System.out.println(str + select);
                System.out.println(option2);
                break;
        }
        i = in.nextInt();
        in.nextLine();
        System.out.println();
        return valid(i, menu);
    }



    public static void nav(String cl) throws IOException
    {
        int i = 0;
        switch (cl)
        {
            case "home":
                i = makeMenu("home");
                //options: "1. Add \t2. Remove \t3. Update \t4. Reports \t5. Exit";
                switch (i)
                {
                    case 1: //Add Menu
                        i = makeMenu("addMenu");
                        //options "1. Advisor \t2. Attendance \t3. Goal \t4. Coaching \t5. Main Menu";
                        switch (i)
                        {
                            case 1:
                                add("Advisor");
                                break;
                            case 2:
                                add("Attendance");
                                break;
                            case 3:
                                add("Goal");
                                break;
                            case 4:
                                add("Coaching");
                                break;
                            case 5:
                                makeMenu("home");
                                break;
                        }
                    case 2 ://remove Menu
                        makeMenu("rmvMenu");
                        //options "1. Advisor \t2. Attendance \t3. Goal \t4. Coaching \t5. Main Menu";
                        switch (i)
                        {
                            case 1:
                                rm("Adv");
                            case 2:
                                rm("Attendance");
                            case 3:
                                rm("Goal");
                            case 4:
                                rm("Coaching");
                            case 5:
                                nav("home");
                        }
                    case 3 ://Update Menu
                        makeMenu("upMenu");
                        //options "1. Advisor \t2. Attendance \t3. Goal \t4. Coaching \t5. Main Menu";
                        switch (i)
                        {
                            case 1:
                                //upAdv();
                                System.out.println("Coaching 1");

                            case 2:
                                // upAttend();
                                System.out.println("Coaching 2");

                            case 3:
                                // upGoals();
                                System.out.println("Coaching 3");

                            case 4:
                                // upCoaching();
                                System.out.println("Coaching 4");
                            case 5:
                                nav("home");
                        }
                    case 4 ://Reports Menu
                        makeMenu("reports");
                        //options "1. Advisor \t2. Attendance \t3. Goal \t4. Coaching \t5. Main Menu";
                        switch (i)
                        {
                            case 1:
                                //report1();
                                System.out.println("report 1");
                            case 2:
                                // report2();
                                System.out.println("report 2");
                            case 3:
                                // report3();
                                System.out.println("report 3");
                            case 4:
                                //report4();
                                System.out.println("report 4");
                            case 5:
                                nav("home");
                        }
                    case 5 ://Reports Menu
                        exit();
                }
        }
    }

    /*
     Menu Input Validation, ensures 1 - Max and String "Y/N" variants to navigate the menu
     */
    private static int valid(int sel, String cl)
    //validates user menu input within accepted range
    {
        int max = 0;
        switch (cl)
        {
            case "home":
            case "rmvMenu":
            case "addMenu":
                max = 5;
                break;

            case "goals":
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

    private static String valid(String sel)

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
            case "No":
            case "n":
            case "NO":
            case "no":
            case "nO":
                 sel = "n";

        }
        return sel;
    }

    public static void exit() throws IOException
    //exits program when user selects Exit Option
    {
        DB.writeObject();
        System.out.println("Good Bye");
        System.exit(0);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();
        nav("home");
    }

}

