import java.io.IOException;


public class Nav
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();

        new Attendance("Daniel Jenkins", "8/15/18", "Full Day", 8, "Test Attendance 1");
        new Goal("Daniel Jenkins", "8/25/18", "Here are some comments");
        new Goal("Daniel Jenkins", "8/25/18", "Here are some comments");
        new Goal("Daniel Jenkins", "8/31/18", "Here are some comments");
        new Goal("Madison Jenkins", "8/25/18", "Here are some comments");
        new Goal("Madison Jenkins", "8/25/18", "Here are some comments");
        new Goal("Madison Jenkins", "8/31/18", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/25/18", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/25/18", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/31/18", "Here are some comments");
        new Coaching("Madison Jenkins", "8/25/18", "Here are some comments");
        new Coaching("Madison Jenkins", "8/25/18", "Here are some comments");
        new Coaching("Madison Jenkins", "8/31/18", "Here are some comments");
        DB.printattendCats("Full Day");


    }

}
