package Other;

import Model.Advisor;
import Model.Attendance;
import Model.Coaching;
import Storage.Records;

import java.io.IOException;

public class IdGenerator
{
    private static int advisorID = 0;


    public IdGenerator(Advisor advisor)
    {
        if (advisor != null)
        {
            advisorID++;
        }
    }


    public static int getAdvisorID()
    {
        return advisorID;
    }

    public  void setAdvisorID(int advisorID)
    {
        IdGenerator.advisorID = advisorID;
    }



}
