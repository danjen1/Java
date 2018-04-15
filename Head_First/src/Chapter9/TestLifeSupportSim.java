package Chapter9;

import java.util.ArrayList;

public class TestLifeSupportSim
{
    public static void main(String[] args)
    {
        ArrayList aList = new ArrayList<>();
        V2Radiator v2 = new V2Radiator(aList);
        V3Radiator v3 = new V3Radiator(aList);
        for (int x = 0; x < 20; x++)
        {
            RetentionBot ret = new RetentionBot(aList);
        }
    }
}
