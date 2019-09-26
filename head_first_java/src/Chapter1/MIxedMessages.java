package Chapter1;

public class MIxedMessages
{
    public static void main(String[] args)
    {
        int x = 0;
        int y = 0;
        while (x < 5)
        {
            //y = x -y;
            y = y + x;
            System.out.println(x + "" + y + " ");
            x++;
        }
    }
}
