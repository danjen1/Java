package Day14;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference
{
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] integers)
    {
        this.elements = integers;
    }

    public int computeDifference()
    {
        int h = 0;
        int l = elements[0];
        for (int i = 0; i < elements.length; i++)
        {

            if (elements[i] > h)
            {
                h = elements[i];
            }
            if (elements[i] < l)
            {
                l = elements[i];
            }
        }
        System.out.println(l + " " + h);
        return maximumDifference = Math.abs(l - h);
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}