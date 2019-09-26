
import java.util.Arrays;

public class Main {

    public static int smallest(int[] array) {
        int smallest = array[0];
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array) {
        int smallest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallestStartingFrom(int[] array, int index) {
        int indexOfSmallest = index;
        for (int i = index; i < array.length; i++) {
            if (array[i] < array[indexOfSmallest]) {
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    public static void swap(int[] array, int index1, int index2) {
        int indexOldVal = array[index1];
        array[index1] = array[index2];
        array[index2] = indexOldVal;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int indx = indexOfTheSmallestStartingFrom(array, i);
            swap(array, i, indx);
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        /*int[] values = {6, 5, 8, 7, 11};
        System.out.println("smallest: " + smallest(values));
       
        int[] values = {6, 5, 8, 7, 11};
        System.out.println("Index of the smallest: " + indexOfTheSmallest(values));
         

        int[] values = {-1, 6, 9, 8, 12};
        System.out.println(indexOfTheSmallestStartingFrom(values, 1));
        System.out.println(indexOfTheSmallestStartingFrom(values, 2));
        System.out.println(indexOfTheSmallestStartingFrom(values, 4));

        int[] values = {3, 2, 5, 4, 8};

        System.out.println(Arrays.toString(values));

        swap(values, 1, 0);
        System.out.println(Arrays.toString(values));

        swap(values, 0, 3);
        System.out.println(Arrays.toString(values));
        */
        
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);

    }

}
