import java.util.*;

public class Day4
{
    private int age;

    public Day4(int initialAge) {
        if (initialAge <= 0)
        {
            System.out.println("Age is not valid, setting age to 0.");
            this.age =0;
        }
        this.age = initialAge;
    }

    public void amIOld() {
        String result;
        if (age < 18 && age >= 13)
        {
            result = "You are a teenager.";
        } else if (age < 13)
        {
            result = "You are young.";
        }else
        {
            result = "You are old.";
        }
        System.out.println(result);
    }

    public void yearPasses() {
        this.age++;
    }

    public static void main(String[] args)
    {
        Day4 one = new Day4(15);
        one.amIOld();
    }

}
