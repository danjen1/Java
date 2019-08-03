package JAVA.Easy;
import java.util.*;

public class StringReverse
{
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        String A = in.next();
        String result = "Yes";
        in.close();

        int len = A.length() / 2;
        if (A.length() < 2)
        {
            System.out.println(result);
        }
        else
        {
            for (int i = 0; i < len; i++)
            {
                if (A.substring(i, i + 1).compareTo(A.substring(A.length() - (i + 1), A.length() - i)) == 0)
                {
                    result = "Yes";
                } else
                {
                    result = "No";
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
