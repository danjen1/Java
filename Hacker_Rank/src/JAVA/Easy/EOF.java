package JAVA.Easy;
import java.util.*;

public class EOF
{
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = 1;
        while (in.hasNext()){
            String ans = in.nextLine();
            System.out.println(count + " " + ans);
            count++;
        }
    }
}

