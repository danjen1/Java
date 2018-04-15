package Chapter1;

public class MyFirstApp
{
    public static void main(String[] args)
    {
        System.out.println("I Rule!");
        System.out.println("The World!");
        int x =3;
        String name = "Dirk";
        x = x * 17;
        System.out.println("x is " + x);
        double d = Math.random();
        //this is a command

        while (x > 12)
        {
            x = x - 1;
        }
        for (int r = 0; r < 10; r = r + 1)
        {
            System.out.println("r is now " + r);
        }
        if (x == 10)
        {
            System.out.println("r must be 10");
        } else
        {
            System.out.println("r isn't 10");
        }
        String fname = "Dirk";
        if ((x < 3) && (fname.equals("Dirkk")))
        {
            System.out.println("Gently");
        }
        System.out.println("This line runs no matter what");
    }
}
