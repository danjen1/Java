package JAVA.Easy;
import java.text.NumberFormat;
import java.util.*;


public class CurrencyFormatter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale j1Locale = new Locale("en", "IN");
        String us = NumberFormat.getCurrencyInstance().format(payment);
        String india = NumberFormat.getCurrencyInstance(j1Locale).format(payment);
        String china = NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment);
        String france = NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment);

        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

    }
}
