package Chapter16;
import java.util.*;

public class SortMountains
{
    LinkedList<Mountain> mtn = new LinkedList<Mountain>();

    class NameCompare implements Comparator<Mountain>
    {
        public int compare(Mountain one, Mountain two)
        {
            return one.name.compareTo(two.name);
        }
    }

    class HeightCompare implements Comparator<Mountain>
    {
        public int compare(Mountain one, Mountain two)
        {
            return (two.height - one.height);
        }
    }

    public static void main(String[] args)
    {
        SortMountains mtn = new SortMountains();
        mtn.go();
    }

    public void go()
    {
        mtn.add(new Mountain("Longs", 14255));
        mtn.add(new Mountain("Elbert", 14433));
        mtn.add(new Mountain("Maroon", 14156));
        mtn.add(new Mountain("Castle", 14265));

        System.out.println("as enter:\n" + mtn);
        NameCompare nc = new NameCompare();
        Collections.sort(mtn, nc);
        System.out.println(mtn);
        HeightCompare hc = new HeightCompare();
        Collections.sort(mtn, hc);
        System.out.println(mtn);
    }
}