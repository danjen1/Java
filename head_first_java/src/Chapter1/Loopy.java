package Chapter1;

public class Loopy
{
    public static void main(String[] args)
    {
        int x = 1;
        System.out.println("Before the Loop: ");
        while (x < 4)
        {
            System.out.println("In the Loop");
            System.out.println("The value of x is " + x);
            x -= 1;
        }
        System.out.println("This is after the loop");
    }
}