import java.io.IOException;

public class Nav
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        DB DB = new DB();
        new Advisor("Cara", "1234", "cara@cara");
        Attendance attend = new Attendance("Cara", "8/17", "Attend0");
        Attendance attend1 = new Attendance("Cara", "8/15", "Attend1");
        new Goal("Daniel", "8/18", "Test 1");
        new Goal("Cara", "8/19", "test1");
        new Coaching ("Cara", "8/20", "sexual");
        DB.print("Attendance");
        DB.print("Goal");
        DB.print("Coaching");
    }

}
