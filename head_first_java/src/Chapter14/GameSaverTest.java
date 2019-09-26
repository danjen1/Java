package Chapter14;

import java.io.*;



public class GameSaverTest
{

    public static void main(String[] args)
    {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"bow", "sword", "dust"});
        GameCharacter two = new GameCharacter(200 , "Troll", new String[] {"bare hands", "big ax"});
        GameCharacter three = new GameCharacter(120, "Magician", new String[] {"spells", "invisibility"});

        try
        {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        one = null;
        two = null;
        three = null;

        try
        {

            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();


            System.out.println("======= =====  =======     =================");
            System.out.printf("%-5s\t" + "%-6s\t" + "%-10s\t" + "%-20s\t\n", "Number", "Power", "Type", "Weapon List");
            System.out.println("======= =====  =======     =================");
            System.out.printf("%-5s\t" + "%-6d\t" + "%-10s\t" + "%-20s\t\n", "1", oneRestore.getPower(), oneRestore.getType(), oneRestore.getWeapons());
            System.out.printf("%-5s\t" + "%-6d\t" + "%-10s\t" + "%-20s\t\n", "2", twoRestore.getPower(), twoRestore.getType(), twoRestore.getWeapons());
            System.out.printf("%-5s\t" + "%-6d\t" + "%-10s\t" + "%-20s\t\n", "3", threeRestore.getPower(), threeRestore.getType(), threeRestore.getWeapons());


        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
