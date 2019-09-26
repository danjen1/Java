package Chapter4;

public class GoodDog
{
    private int size;

    public int getSize()
    {
        return size;
    }
    public void setSize(int n)
    {
        size = n;
    }
    void bark()
    {
        if (size > 60)
        {
            System.out.println("Woof! WOof!");
        } else if (size > 14)
        {
            System.out.println("Ruff! Ruff!");
        } else
        {
            System.out.println("Yip! Yip!");
        }
    }
}
