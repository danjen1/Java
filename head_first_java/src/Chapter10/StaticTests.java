package Chapter10;

public class StaticTests extends StaticSuper
{
    static int rand;

    static
    {
        rand = (int) (Math.random() * 6);
        System.out.println("static block " + rand);
    }

    StaticTests()
    {
        System.out.println("constructor");

    }

    public static void main(String[] args)
    {
        System.out.println("in main");
        StaticTests st = new StaticTests();
    }
}

/* output all static variables / methods get instantiated first including main
super static block =  static method in StaticSuper
static block 4 = static method in StaticTests
in main = static main method
super constructor called from StaticSuper
constructor called from StaticTests
 */


