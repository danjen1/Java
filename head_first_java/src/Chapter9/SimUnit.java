package Chapter9;

public class SimUnit
{
    String botType;

    SimUnit(String type)
    {
        botType = type;
        System.out.println("New SimUnit Created");
    }

    int PowerUse()
    {
        if ("Retntion".equals(botType))
        {
            return 2;
        } else
        {
            return 4;
        }
    }
}
