import java.io.IOException;

public class Program
{
    /* Main Method Testing */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {

        DB db = new DB();
        db.readObject();


        db.addAdv();
        db.writeObject();

    }
}
