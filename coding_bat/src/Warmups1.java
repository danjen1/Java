public class Warmups1
{
    public boolean sleepIn(boolean weekday, boolean vacation)
    {
        if (!weekday || vacation)
        {
            return true;
        }
        return false;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile)
    {
        if (aSmile && bSmile || !aSmile && !bSmile)
        {
            return true;
        }
        return false;
    }

    public int sumDouble(int a, int b)
    {
        if (a == b)
        {
            return (a + b) * 2;
        }
        return a + b;
    }

    public boolean posNeg(int a, int b, boolean negative)
    {
        if ((negative && a < 0 && b < 0) || (!negative && a < 0 && b > 0 || !negative && a > 0 && b < 0))
        {
            return true;
        }
        return false;
    }

    public String notString(String str)
    {
        if (str.length() >= 3 && str.substring(0, 3).equals("not"))
        {
            return str;
        }
        return "not " + str;
    }

    public String missingChar(String str, int n)
    {
        String str1 = str.substring(0, n);
        String str2 = str.substring(n + 1, str.length());
        return str1 + str2;
    }


    public int diff21(int n)
    {
        if (n <= 21)
        {
            return 21 - n;
        } else
        {
            return (n - 21) * 2;
        }
    }

    public boolean parrotTrouble(boolean talking, int hour)
    {
        if (talking && hour < 7 || talking && hour > 20)
        {
            return true;
        }
        return false;
    }

    public boolean makes10(int a, int b)
    {
        if (a + b == 10 || a == 10 || b == 10)
        {
            return true;
        }
        return false;
    }

    public boolean nearHundred(int n)
    {
        if (Math.abs(200 - n) <= 10 || Math.abs(100 - n) <= 10)
        {
            return true;
        }
        return false;
    }

    public String frontBack(String str)
    {
        if (str.length() > 1)
        {
            String last = str.substring(str.length() - 1, str.length());
            String first = str.substring(0, 1);
            return last + str.substring(1, str.length() - 1) + first;
        }
        return str;
    }

    public String front3(String str)
    {
        int n = str.length();
        if (n < 3)
        {
            str = str.substring(0, n);
            return str + str + str;
        }
        str = str.substring(0, 3);
        return str + str + str;
    }

    public String backAround(String str)
    {
        String last = str.substring(str.length() - 1, str.length());
        return last + str + last;
    }

    public boolean or35(int n)
    {
        if (n % 5 == 0 || n % 3 == 0)
        {
            return true;
        }
        return false;
    }

    public String front22(String str)
    {
        if (str.length() < 2)
        {
            return str + str + str;
        }
        String str1 = str.substring(0, 2);
        return str1 + str + str1;
    }

    public boolean startHi(String str)
    {
        return (str.length() > 1 && str.substring(0, 2).equals("hi"));

    }

    public boolean icyHot(int temp1, int temp2)
    {
        return (temp1 > 100 && temp2 < 0 || temp1 < 0 && temp2 > 100);

    }

    public boolean in1020(int a, int b)
    {
        return (a >= 10 && a <= 20 || b >= 10 && b <= 20);

    }

    public boolean hasTeen(int a, int b, int c)
    {
        return (a >= 13 && a <= 19) ||
                (b >= 13 && b <= 19) ||
                (c >= 13 && c <= 19);
    }

    public boolean loneTeen(int a, int b)
    {
        boolean aTeen = (a >= 13 && a <= 19);
        boolean bTeen = (b >= 13 && b <= 19);

        return (aTeen && !bTeen || !aTeen && bTeen);
    }

    public String delDel(String str)
    {
        if (!str.substring(1, 4).equals("del") || str.length() < 4)
        {
            return str;
        }
        int n = str.length();
        String f = str.substring(0, 1);
        return f + str.substring(4, n);
    }

    public boolean mixStart(String str)
    {
        if (str.length() >= 3 && str.substring(1, 3).equals("ix"))
        {
            return true;

        }
        return false;
    }

    public String startOz(String str)
    {
        String result = "";
        if (str.length() >= 1 && str.charAt(0) == 'o')
        {
            result = result + str.charAt(0);
        }

        if (str.length() >= 2 && str.charAt(1) == 'z')
        {
            result = result + str.charAt(1);
        }

        return result;
    }

    public int intMax(int a, int b, int c)
    {
        int max = Math.max(a, b);
        max = Math.max(max, c);
        return max;
    }

    public int close10(int a, int b)
    {
        int aDiff = Math.abs(a - 10);
        int bDiff = Math.abs(b - 10);

        if (aDiff < bDiff)
        {
            return a;
        }
        if (bDiff < aDiff)
        {
            return b;
        }
        return 0;
    }

    public boolean in3050(int a, int b)
    {
        boolean rangeA = (a >= 30 && a <= 40 && b >= 30 && b <= 40);
        boolean rangeB = (a >= 40 && a <= 50 && b >= 40 && b <= 50);
        return (rangeA || rangeB);
    }

    public int max1020(int a, int b)
    {
        if (b > a)
        {
            int temp = a;
            a = b;
            b = temp;
        }

        // Knowing a is bigger, just check a first
        if (a >= 10 && a <= 20) return a;
        if (b >= 10 && b <= 20) return b;
        return 0;
    }

    public boolean stringE(String str)
    {
        int n = 0;
        int e = 0;

        while (n < str.length())
        {
            if (str.substring(n, n + 1).equals("e"))
            {
                e++;
            }
            n++;
        }
        return (e >= 1 && e <= 3);
        /*
          int count = 0;
          for (int i=0; i<str.length(); i++) {
          if (str.charAt(i) == 'e') count++;
       or: str.substring(i, i+1).equals("e")
         */
    }

    public boolean lastDigit(int a, int b)
    {
        return (a % 10 == b % 10);
    }

    public String endUp(String str)
    {
        if (str.length() < 3)
        {
            return str.toUpperCase();
        }
        return str.substring(0,str.length()-3) + str.substring(str.length()-3,str.length()).toUpperCase();
    }

    public String everyNth(String str, int n)
    {
        String str2 = "";
        for (int i = 0; i < str.length(); i += n)
        {
            str2 += str.charAt(i);
        }
        return str2;
    }


    public static void main(String[] args)
    {
        Warmups1 one = new Warmups1();
        boolean status = one.sleepIn(true, false);
        System.out.println("Sleepin status: " + status);

        boolean monkeyStatus = one.monkeyTrouble(true, true);
        System.out.println(monkeyStatus);

        one.diff21(19);
        System.out.println(one.diff21(-5));

        System.out.println(one.missingChar("kitten", 1));
        System.out.println(one.frontBack("kitten"));

    }


}


