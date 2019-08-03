package Arrays;

public class ArraySort
{

    public void bubbleSort(int[] arr)
    {
        for (int x = 1; x < arr.length; x++)
        {
            boolean swapped = false;
            for (int y = 0; y < arr.length-x-1; y++)
            {
                if (arr[y] > arr[y + 1])
                {
                    int temp = arr[y];
                    arr[y] = arr[y + 1];
                    arr[y + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
            {

                break;
            }
        }
    }
}
