import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class converter
{
    public static void main(String[] args) {
       //Form time = new Form();

        Scanner in = new Scanner(System.in);
        boolean go = true;
        double num1 = 0;
        double num2 = 0;

        do
        {
            System.out.println("Input:");
            num1 = in.nextDouble();
            num2 = in.nextDouble();
            if (num1 == 0 && num2 == 0){
                break;
            }
            if (num2 == 0.00)
            {
                System.out.printf("%.2f", dt(num1));
                System.out.println();
                System.out.println();


            } else {
                double a = dt(num1, num2);
                double dec = (a - (long) a) * 60;
                System.out.println(a + " " + dec);
                System.out.print("PAID: ");
                System.out.printf("%.0f", Math.floor(a));
                System.out.println(" hours " + Math.round(dec) + " minutes");
                System.out.println();
            }

        }
        while (go);
    }
    public static double dt(double shft,  double hrs){
         return (shft - hrs) / 2;
    }
    public static double dt(double cnvrt){
        return cnvrt / 60;
    }
}

