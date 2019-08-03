import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day11
{

    public static void main(String[] args)
    {
        //Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                arr[i][j] = (int) (Math.random() * 10);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int bigSum = Integer.MIN_VALUE, tempSum, dCount = 0;
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                tempSum = 0;
                tempSum += arr[i][j];
                tempSum += arr[i][j + 1];
                tempSum += arr[i][j + 2];
                tempSum += arr[i + 1][j + 1];
                tempSum += arr[i + 2][j];
                tempSum += arr[i + 2][j + 1];
                tempSum += arr[i + 2][j + 2];
                dCount++;
                if (tempSum > bigSum)
                {
                    bigSum = tempSum;
                    System.out.println("tempSum: " + tempSum + " the diamound count is: " + dCount);
                }
            }
        }
        System.out.println("the biggest diamond was " + bigSum);

    }
}
