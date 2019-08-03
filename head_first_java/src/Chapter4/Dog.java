package Chapter4;

public class Dog
{
    int size;
    String name;

    void bark()
    {
        if (size > 60)
        {
            System.out.println("Woof! Woof!");
        } else if (size > 14)
        {
            System.out.println("Ruff! Ruff!");
        }else
        {
            System.out.println("Yip! Yip!");
        }
    }
    void barkNum(int numBarks)
    {
        while (numBarks > 0)
        {
            System.out.println("Ruff");
            numBarks--;
        }
    }
   /* void go()
    {
        Dog t = new Dog();
        t.takeTwo(3,4);
    }

    void takeTwo(int x, int y,)
    {
        int z = x + y;
        System.out.println("Total is " + z);
    }
    */
}
