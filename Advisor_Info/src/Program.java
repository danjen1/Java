import java.io.IOException;


public class Program
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Records_DB db = new Records_DB();
        db.readObject();
        db.add_Adv();
        db.writeObject();
        db.addOccur("123456");
    }
}
