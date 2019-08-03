import java.util.*;

public class Day2
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        in.close();

        double tip = meal_cost * tip_percent / 100;
        double tax = meal_cost * tax_percent / 100;
        double totalCost = (meal_cost + tax + tip);
        int totalRoundedCost = (int) Math.round(totalCost);
        System.out.println("The total meal cost is " + totalRoundedCost + " dollars.");

    }
}
