public class Logic_1
{
    public boolean cigarParty(int cigars, boolean isWeekend)
    {
        if (isWeekend)
        {
            return cigars >= 40;
        } else return cigars >= 40 && cigars <= 60;
    }

    public int dateFashion(int you, int date)
    {
        // Check the <=2 case first, since it takes precedence
        // over the >=8 case.
        if (you <= 2 || date <= 2)
        {
            return 0;
        } else if (you >= 8 || date >= 8)
        {
            return 2;
        } else
        {
            return 1;
        }
    }

    public boolean squirrelPlay(int temp, boolean isSummer)
    {
        if (isSummer)
        {
            if (temp <= 100 && temp >= 60)
            {
                return true;
            }
        }
        return temp >= 60 && temp <= 90;
    }

    public int caughtSpeeding(int speed, boolean isBirthday)
    {
        if (isBirthday)
        {
            if (speed >= 86)
            {
                return 2;
            } else if (speed >= 66 && speed <= 85)
            {
                return 1;
            } else
            {
                return 0;
            }
        } else if (speed >= 81)
        {
            return 2;
        } else if (speed >= 61 && speed <= 80)
        {
            return 1;
        }
        return 0;
    }

    public int sortaSum(int a, int b)
    {
        int sum = a + b;
        if (sum <= 19 && sum >= 10)
        {
            return 20;
        }
        return sum;
    }

    public String alarmClock(int day, boolean vacation)
    {
        if (vacation)
        {
            if (day >= 1 && day <= 5)
            {
                return "10:00";
            }
            return "off";
        } else if (day >= 1 && day <= 5)
        {
            return "7:00";
        }
        return "10:00";
    }
    public static void main(String[] args) {
        Logic_1 one = new Logic_1();
        System.out.println(one.alarmClock(7, false));
    }
}

