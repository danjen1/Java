package JAVA.Easy;
import java.util.*;

public class Stringies
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String A = in.next();
        String B = in.next();

        int count = A.length() + B.length();
        int ans =  B.compareTo(A);
        String result = "Yes";
        if (ans >= 0) result = "No";

        System.out.println(count);
        System.out.println(result);
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " +
                B.substring(0, 1).toUpperCase() + B.substring(1));
    }
}
