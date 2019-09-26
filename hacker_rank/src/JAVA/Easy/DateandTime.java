package JAVA.Easy;
import java.util.*;

import java.time.DayOfWeek;

public class DateandTime
{
    public static String getDay(String day, String month, String year)
    {

        Calendar s = Calendar.getInstance();
        s.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day));
        return s.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();

    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String month = in.next();
        String day = in.next();
        String year = in.next();

        System.out.println(getDay(day, month, year));
    }
}