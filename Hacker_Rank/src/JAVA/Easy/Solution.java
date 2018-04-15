package JAVA.Easy;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        /*System.out.println("Hello, World.");
        System.out.println("Hello, Java.");


        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c); */

        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++)
        {
            String s1 = sc.next();
            int x = sc.nextInt();
            System.out.printf("%-15s", s1);
            System.out.printf("%03d", x);
            System.out.println();
        }
        System.out.println("================================");


    }
}
