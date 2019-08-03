package Chapter9;
import java.util.*;

public class V2Radiator
{
    V2Radiator(ArrayList list)
    {
        for (int x = 0; x < list.size(); x++)
        {
            list.add(new SimUnit("V2Radiator"));
        }
    }

    V2Radiator()
    {

    }
}
