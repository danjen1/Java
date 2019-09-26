import java.util.*;
import java.io.*;

public class Day6
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int test = in.nextInt();

        for (int i = 0; i < test; i++)
        {
            String string = in.next();

            for (int j = 0; j < string.length(); j += 2)
            {
                System.out.print(string.charAt(j));
            }
            System.out.print(" ");
            for (int k = 1; k < string.length(); k += 2)
            {
                System.out.print(string.charAt(k));
            }
            System.out.println();
        }

    }
}