
import java.util.Scanner;


public class UpToCertainNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int limit = Integer.parseInt(reader.nextLine());
        int c = 1;
        while (c <= limit){
            System.out.println(c);
            c++;
        }
       
            
    }
}
