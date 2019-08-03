package Chapter9;

import java.util.ArrayList;

class V3Radiator extends V2Radiator
{
    V3Radiator(ArrayList lglist)
    {
        super(lglist);
        for (int x = 0; x < lglist.size(); x++)
        {
            lglist.add(new SimUnit("V3Radiator"));
        }
    }
}
