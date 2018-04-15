package JAVA.Easy;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SubStringComps
{
    public static String getSmallestAndLargest(String s, int k)
    {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for (int i = 1; i < s.length() - k + 1; i++)
        {
            if (s.substring(i, i + k).compareTo(smallest) < 0)
            {
                smallest = s.substring(i, i + k);
            } else if (s.substring(i, i + k).compareTo(largest) > 0)
            {
                largest = s.substring(i, i + k);
            }
        }
        return smallest + "\n" + largest;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        in.close();

        System.out.println(getSmallestAndLargest(s, k));

    }
}
