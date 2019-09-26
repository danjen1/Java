import java.util.*;

public class Day3
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        String ans="";

        // if 'n' is NOT evenly divisible by 2 (i.e.: n is odd)
        if(n%2==1 || n%2==0 && n<21 && n>5) {
            ans = "Weird";
        }
        else{
            ans = "Not Weird";
        }
        System.out.println(ans);
    }
}
   /*   If  is odd, print Weird
        If  is even and in the inclusive range of 2 to 5, print Not Weird
        If  is even and in the inclusive range of 6 to 20, print Weird
        If  is even and greater than , print Not Weird */

