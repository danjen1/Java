package Chapter7;

public class TestBoats
{
    public static void main(String[] args)
    {
        Boats b1 = new Boats();
        Sailboat b2 = new Sailboat();
        Rowboat b3 = new Rowboat();

        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }
}
