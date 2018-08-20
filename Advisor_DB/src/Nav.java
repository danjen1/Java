import java.io.IOException;


public class Nav
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        DB DB = new DB();
        
        //DB.rmv("Daniel ", "8/15/18", "Attendance");
        /*
        new Advisor("Daniel Jenkins", "123455", "553432", "dan@dan.com", "Active", "8x5", "M-F 9-5", true, "801-300-0056", "EST", "05/13/2013", "8/15", "3182 College Court Elko, NV 89801");
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
        */
        DB.printAttend("Daniel Jenkins");
    }

}