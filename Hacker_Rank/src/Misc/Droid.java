package Misc;

public class Droid
{
    int batterylevel;

    public Droid(){
         batterylevel = 100;
    }

    public void activate ()
    {
        System.out.println("Activated. How can i help you?");
        batterylevel = batterylevel - 5;
        System.out.println("Battery level is: " + batterylevel + " percent.");
    }

    public void chargeBattery(int hours)
    {
        System.out.println("Misc.Droid charging...");
        batterylevel = batterylevel + hours;
        if (batterylevel > 100)
        {
            batterylevel = 100;}
        else
        {
            System.out.println("batterylevel is " + batterylevel + " %");
        }
    }
    public int checkbatterylevel()
    {
        System.out.println("batterylevel is" + batterylevel + "%");
        return batterylevel;
    }
    public void hover (int feet){
        if ( feet > 2)
        {
            System.out.println("Error! I cant hover above 2 feet");}
        else {
            System.out.println("hovering...");
            batterylevel = batterylevel - 20;
            System.out.println( "batterylevel is " + batterylevel + " %");
        }
    }
    public static void main(String[] args)
    {
        Droid ray = new Droid();
        ray.activate();
        ray.chargeBattery(5);
        ray.hover(2);
    }
}