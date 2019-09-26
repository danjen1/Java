package Arrays;

import java.util.ArrayList;

public class MainTester
{
    public static void main(String[] args)
    {
        ArraySort test = new ArraySort();
        int[] arrayToSort = {1, 3, 2, 9, 4, 15, 7, 21, 18, 145, 6, 89, 76};
        test.bubbleSort(arrayToSort);
        for (int x = 0; x < arrayToSort.length - 1; x++)
        {
            System.out.println(arrayToSort[x]);
        }
    }
}
