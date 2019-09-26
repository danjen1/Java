
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Test your program here
        int[] table = {-3, 2, 3, 4, 7, 8, 12};
        Scanner reader = new Scanner(System.in);

        System.out.print("Numbers in the array " + Arrays.toString(table));
        System.out.println();

        System.out.print("Enter searched number: ");
        String searched = reader.nextLine();
        System.out.println();

        boolean result = BinarySearch.search(table, Integer.parseInt(searched));
        if (result){
            System.out.println("Value " + searched + " is in the array");
        }else{
            System.out.println("Value " + searched + " is not in the array");
        }
        
    }
}
