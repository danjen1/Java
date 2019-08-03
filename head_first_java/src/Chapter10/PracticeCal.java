package Chapter10;

import java.util.*;

public class PracticeCal
{
    public static void main(String[] args)
    {

        /* Key Calendar Methods
        add(int field, int amout) Adds or subs time from the calendar's field
        get(int field) Returns the value of the given calendar field
        getInstance() Returns a Calendar you can specify a locale
        getTimeinMillis() Returns this calendar's time in millis as a long
        roll(int field, bollean up) Adds or substratcts time wtihout changing the larger fields
        set(int filed, int value) Sets the value of a given calendar field
        set(year,month,day,hour,minute) (all ints) A common variety of set to set a complete time
        setTimeInMillis(long millis) seta a clanedar's time based on a long millitime

        Calendar Fields
        DATE / DAY_OF_MONTH Get / set the day of the month
        HOUR / HOUR_OF_DAY / Get / set the 12 hour or 24 hour value
        MILLISECOND  Get / set the milliseconds
        MINUTE Get / set the minute
        MONTH  Get/ set the mount
        YEAR  Get / set the year
        ZONE_OFFSET Get / set raw offset of GMT in millis
         */

        Calendar c = Calendar.getInstance();
        c.set(2004, 0, 7, 15, 40);
        long day1 = c.getTimeInMillis();
        System.out.printf("%,d", day1);
        System.out.println();
        System.out.println(c.getTime());
        day1 += 1000 * 60 * 60;
        c.setTimeInMillis(day1);
        System.out.println("new hour " + c.get(c.HOUR_OF_DAY));
        c.add(c.DATE, 35);
        System.out.println("add 25 days " + c.getTime());
        c.roll(c.DATE, 35);
        System.out.println("roll 35 days " + c.getTime());
        c.set(c.DATE, 1);
        System.out.println("set to 1 " + c.getTime());

    }
}

