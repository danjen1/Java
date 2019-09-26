package JAVA.Easy;
import java.util.*;

class RegEx
{
    public static final String regularExpression = "^[A-Za-z]\\w{7,29}$";

    public static class Solution
    {

        private static final Scanner scan = new Scanner(System.in);

        public static void main(String[] args)
        {
            try
            {
                int n = Integer.parseInt(scan.nextLine());
                while (n-- != 0)
                {
                    String userName = scan.nextLine();
                    if (userName.matches(RegEx.regularExpression))
                    {
                        System.out.println("Valid");
                    } else
                    {
                        System.out.println("Invalid");
                    }
                }
            } catch (Exception e)
            {
                System.out.println("Must be a number");
            }
        }
    }
}
