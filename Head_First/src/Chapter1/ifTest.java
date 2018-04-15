package Chapter1;

public class ifTest
{
    public static void main(String[] args)
    {
        int x = 3;
        if (x == 3)
        {
            System.out.println("x must be 3");
        }
        System.out.println("This runs no matter what");

        int r = 2;
        if (r == 3)
        {
            System.out.println("r must be 3");
        } else
        {
            System.out.println("r must not be 3");
        }
        System.out.println("This runs no matter what");
    }

}
