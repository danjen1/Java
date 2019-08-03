import java.util.*;

public class Day7
{
    public static void main(String[] args)
    {
        System.out.println("Enter the number of numbers:");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for(int i=0; i < n; i++)
        {
            System.out.println("Number" + i+1 + ":");
            arr[i] = in.nextInt();
        }
        in.close();

        for (int i = arr.length - 1; i >= 0; i--)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
