import java.io.IOException;

public class Nav
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();
        new Attendance("Daniel Jenkins", "8/25", "Here are some comments");
        new Attendance("Daniel Jenkins", "8/25", "Here are some comments");
        new Attendance("Daniel Jenkins", "8/31", "Here are some comments");
        new Attendance("Jorge Rodriquez", "8/25", "Here are some comments");
        new Attendance("Jorge Rodriquez", "8/25", "Here are some comments");
        new Attendance("Jorge Rodriquez", "8/31", "Here are some comments");
        new Goal("Daniel Jenkins", "8/25", "Here are some comments");
        new Goal("Daniel Jenkins", "8/25", "Here are some comments");
        new Goal("Daniel Jenkins", "8/31", "Here are some comments");
        new Goal("Jorge Rodriquez", "8/25", "Here are some comments");
        new Goal("Jorge Rodriquez", "8/25", "Here are some comments");
        new Goal("Jorge Rodriquez", "8/31", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/25", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/25", "Here are some comments");
        new Coaching("Daniel Jenkins", "8/31", "Here are some comments");
        new Coaching("Jorge Rodriquez", "8/25", "Here are some comments");
        new Coaching("Jorge Rodriquez", "8/25", "Here are some comments");
        new Coaching("Jorge Rodriquez", "8/31", "Here are some comments");
        DB.printAll();


    }

}
