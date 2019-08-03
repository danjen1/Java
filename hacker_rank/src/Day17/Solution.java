package Day17;
import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0)
        {
            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalc = new Calculator();
            try
            {
                int ans = myCalc.power(n, p);
                System.out.println(ans);
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
