import java.util.*;

public class Day5
{
    public static void main(String[] args)
    {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();

            for (int x = 1; x < 11; x++)
            {
                int result = n * x;
                System.out.println(n + " x " + x + " = " + result);
            }
    }
}
