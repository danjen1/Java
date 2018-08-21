import java.io.IOException;
/*
TO DO:
Create nav system starting with Advisor Roster of Active Employees, separated by Employees on leave.  Include
most pertinent information on the roster, EID/ DSID/ Schedule, Status, Address etc.
Leave section include Advisor Name, leave type, RTW Date, Medical Due Date, Comments
TOtal number active / inactive Advisors and nav system
1. Select Advisor to work with / Add / Delete
2. Selected Advisor, Add, Delete, Update (Attend/Coaching/Leave/Goal)
3. Print Coaching Summary in date range (default 180 days) How many 1x1s/Check-ins/etc Print Attendance events (default date range 180).
4. Update print formatting for Goals/Coaching, include word wrap and ability to update progress header categories, the goal on a new line
and updates dated on new lines below the goal with a space between Goals.
5. Create update menus for Attendance, Coaching, Goals, Leaves tie into Nav system
6. Implement Library to read in Numbers documents for historical coaching
7. Create .jar file and production app. Compile classes and devise serialization methodology. Create version numbers.
 */

public class Nav
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        DB DB = new DB();
        




        //DB.rmv("Daniel ", "8/15/18", "Attendance");

       /*new Advisor("Daniel Jenkins", "123455", "553432", "dan@dan.com", "Active", "8x5", "M-F 9-5", true, "801-300-0056", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
        new Advisor("Madison Jenkins", "123455", "553432", "maddy@maddy.com", "Active", "8x5", "SMTWF 9:00am - 6:00pm",true, "801-360-5225", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
        new Attendance("Madison Jenkins", "8/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/13/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/13/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "Full Day", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "Full Day", 8, "Test2");

        new Attendance("Madison Jenkins", "8/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "HomeDT", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "HomeDT", 8, "Test2");

        new Attendance("Madison Jenkins", "8/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "AppleDT", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "AppleDT", 8, "Test2");

        new Attendance("Daniel Jenkins", "8/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "Partial Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "Full Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "Partial Day", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "Partial Day", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "iLOA", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "iLOA", 8, "Test2");


        new Attendance("Madison Jenkins", "8/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "LOA", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "LOA", 8, "Test2");


        new Attendance("Madison Jenkins", "8/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "7/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "6/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Madison Jenkins", "8/13/18", "Vacation", 8, "Test Attendance 2");

        new Attendance("Madison Jenkins", "4/13/18", "Vacation", 8, "Test2");

        new Attendance("Daniel Jenkins", "8/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "HomeDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "4/13/18", "HomeDT", 8, "Test2");
        new Attendance("Daniel Jenkins", "8/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "AppleDT", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "4/13/18", "AppleDT", 8, "Test2");
        new Attendance("Daniel Jenkins", "8/16/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "iLOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "4/13/18", "iLOA", 8, "Test2");
        new Attendance("Daniel Jenkins", "8/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "LOA", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "4/13/18", "LOA", 8, "Test2");
        new Attendance("Daniel Jenkins", "8/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "7/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "6/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/16/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "8/13/18", "Vacation", 8, "Test Attendance 2");
        new Attendance("Daniel Jenkins", "4/13/18", "Vacation", 8, "Test2");


        new Goal("Daniel Jenkins", "8/20/18", "On-Call", "Yadda Yadda Yadda", "Assure", "FY18P4", true);
        new Coaching("Daniel Jenkins", "8/20/18", "1x1", "Here are your 1x1 comments");

        new Coaching("Daniel Jenkins", "8/15/18", "1x1","erea aerask;;;;;;;;;;djla;ldfjl;ajfdklas;fjdlsa;dfjla;dfjas;dfjlas;jfdls;ajfla;jfdl;sajfdl;jas;lfjdslkajsdl;fjas;dfj;aljsadlfs;afja;lsfjka;dsfjadls;a");

        DB.printAttend("Daniel Jenkins");

       // DB.printEvertything();


      /*new Advisor("Daniel Jenkins", "123455", "553432", "dan@dan.com", "Active", "8x5", "M-F 9-5", true, "801-300-0056", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
        new Goal("Daniel Jenkins", "8/20/18", "QDR", "Innovation", "FY18P5", "Present in 3 team meetings", true);
        new Coaching("Daniel Jenkins", "8/20/18", "Additional Development", "AD comms");
        new Goal("Daniel Jenkins", "8/20/18", "Contribution", "Teamwork", "N/A", "Sent emails to the team about hydration", false);

        //new Attendance("Daniel Jenkins", "8/20/18", "KinCare", 3.5, "Reviewed KinCare balances");
        //new Attendance("Daniel Jenkins", "8/20/18", "ROD", 1, "Completed ROD recapped time away balances");
        //DB.printAttend("Daniel Jenkins");
        DB.printGoals("Daniel Jenkins");
        DB.printCoaching("Daniel Jenkins");
        DB.rmv("Daniel Jenkins", "8/20/18", "Attendance");
*/
        DB.printEvertything();
        DB.updateAdvInfo("Daniel Jenkins");

    }

}