package Chapter10;
import java.util.*;


//%[argument number] [flags] [width] [.precision] type
public class Specifier
{
    public static void main(String[] args)
    {
        System.out.printf("%,6.1f", 4455.56);
        System.out.println();
        // %d decimal
        System.out.printf("decimal %d", 41);
        System.out.println();
        //"%.3f", 42.000000 floating point
        System.out.printf("floating point %.3f", 42.0000);
        System.out.println();
        //"%x", 42 hexcadecimal
        System.out.printf("hexadecimal %x", 42);
        System.out.println();
        //"%c", 42
        System.out.printf("character %c", 42);
        System.out.println();

        int one = 20456654;
        double two = 100567890.248907;
        String s = String.format("The rank is %,d out of %,.2f", one, two);
        System.out.println(s);

        System.out.printf("Complete Date: %tc", new Date());
        System.out.println();
        System.out.printf("Just the Time: %tr", new Date());
        System.out.println();

        Date today = new Date();
        String upDate = String.format("Normal Date: %tA, %tB, %td", today, today, today);
        System.out.println(upDate);
        Date day = new Date();
        String downDate = String.format("Normal date simplified %tA, %<tB %<td", today);
        System.out.println(downDate);
    }
}
