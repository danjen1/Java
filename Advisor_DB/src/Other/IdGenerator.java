package Other;

import Model.Advisor;

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

    public  void setAdvisorID(int partID)
    {
        IdGenerator.advisorID = partID;
    }

}
