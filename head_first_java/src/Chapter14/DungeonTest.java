package Chapter14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DungeonTest
{
    public static void main(String[] args)
    {
        DungeonGame d = new DungeonGame();
        System.out.println(d.getX() + d.getY() + d.getZ());
        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("dg.ser"));
            os.writeObject(d);
            os.close();
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("dg.ser"));
            d = (DungeonGame) is.readObject();
            is.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(d.getX() + d.getY() + d.getZ());
    }
}
