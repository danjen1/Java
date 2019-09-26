import java.io.*;
import java.util.*;

public class Day10
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        String a = Integer.toBinaryString(n);
        System.out.println(a);
        int prior = 0, rem = 0, total = 0;

        while (n > 0)
        {
            rem = n % 2;
            n = n / 2;
            if (rem == 1)
            {
                prior++;
                if (prior >= total)
                {
                    total = prior;
                }
            } else
            {
                prior = 0;
            }
        }
        System.out.println(total);
    }
}

