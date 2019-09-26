import java.lang.*;

public class FizzBuzz
{

    /*Given a string str, if the string starts with "f" return "Fizz".
    If the string ends with "b" return "Buzz". If both the "f" and "b"
    conditions are true, return "FizzBuzz". In all other cases, return the
    string unchanged. (See also: FizzBuzz Code)*/

    public String fizzString(String str)
    {
        int length = str.length();

        if (str.charAt(0) == 'f' && str.charAt(length - 1) == 'b')
        {
            return "FizzBuzz";
        } else if (str.charAt(0) == 'f')
        {
            return "Fizz";
        } else if (str.charAt(length - 1) == 'b')
        {
            return "Buzz";
        }
        return str;
    }

    /* Given an int n, return the string form of the number followed by "!".
    So the int 6 yields "6!". Except if the number is divisible by 3 use "Fizz"
    instead of the number, and if the number is divisible by 5 use "Buzz", and if
    divisible by both 3 and 5, use "FizzBuzz". Note: the % "mod" operator computes
    the remainder after division, so 23 % 10 yields 3. What will the remainder be
    when one number divides evenly into another?*/

    public String fizzString2(int n)
    {
        String one = Integer.toString(n);
        if (n % 3 == 0 && n % 5 == 0)
        {
            return "FizzBuzz!";
        } else if (n % 3 == 0)
        {
            return "Fizz!";
        } else if (n % 5 == 0)
        {
            return "Buzz!";
        }
        return one + "!";
    }

    /*Given a number n, create and return a new int array of length n, containing
     the numbers 0, 1, 2, ... n-1. The given n may be 0, in which case just return
      a length 0 array. You do not need a separate if-statement for the length-0
      case; the for-loop should naturally execute 0 times in that case, so it just works.
      The syntax to make a new int array is: new int[desired_length]*/

    public int[] fizzArray(int n)
    {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = i;
        }
        return nums;
    }

    /*Given a number n, create and return a new string array of length n, containing the
     strings "0", "1" "2" .. through n-1. N may be 0, in which case just return a length
     0 array. Note: String.valueOf(xxx) will make the String form of most types. The syntax
     to make a new string array is: new String[desired_length] */

    public String[] fizzArray2(int n){
        String[] strArray = new String[n];


        for (int i = 0; i < n; i++)
        {
            strArray[i] = String.valueOf(i);
        }
        return strArray;

    }

    /* Given start and end numbers, return a new array containing the sequence of integers from
     start up to but not including end, so start=5 and end=10 yields {5, 6, 7, 8, 9}. The
     end number will be greater or equal to the start number. Note that a length-0 array is valid.*/

    public int[] fizzArray3(int start, int end)
    {

        int diff = end - start;
        int[] intArray = new int[diff];
        for (int i = 0; i < diff; i++)
        {
            intArray[i] = start;
            start++;
        }
        return intArray;
    }

    /*Consider the series of numbers beginning at start and running up to but not including end,
    so for example start=1 and end=5 gives the series 1, 2, 3, 4. Return a new String[] array containing
     the string form of these numbers, except for multiples of 3, use "Fizz" instead of the number, for
     multiples of 5 use "Buzz", and for multiples of both 3 and 5 use "FizzBuzz". In Java, String.valueOf(xxx)
      will make the String form of an int or other type. This version is a little more complicated than the
      usual version since you have to allocate and index into an array instead of just printing, and we vary
       the start/end instead of just always doing 1..100.*/

    public String[] fizzBuzz(int start, int end)
    {
        int dif = end - start;
        String[] strs = new String[dif];
        for (int i = 0; i < dif; i++)
        {
            if (start % 3 == 0 && start % 5 == 0)
            {
                strs[i] = "FizzBuzz";
            } else if (start % 5 == 0)
            {
                strs[i] = "Buzz";
            } else if (start % 3 == 0)
            {
                strs[i] = "Fizz";
            } else
            {
                strs[i] = String.valueOf(start);
            }
            start++;
        }
        return strs;
    }

    public String makeOutWord(String out, String word)
    {
        return out.substring(0, 2) + word + out.substring(2, 4);
    }

    public String extraEnd(String str) {
        return str.substring(str.length() - 2, str.length()) + str.substring(str.length() - 2, str.length())
                + str.substring(str.length() - 2, str.length());


    }

    public String firstTwo(String str) {
        int len = str.length();
        if (len < 2)
        {
            return str;
        } else
        {
            return str.substring(0, 2);
        }

    }

    public String firstHalf(String str) {
        int len2 = str.length();
        return str.substring(0, (len2 / 2));

    }
    public String withoutEnd(String str) {
        return str.substring(1, str.length() - 1);

    }

    public String comboString(String a, String b) {
        int decide =  (a.length() > b.length()) ? 1 : 0;
        if (decide == 1)
        {
            return b + a + b;
        } else
        {
            return a + b + a;
        }
    }

    public String nonStart(String a, String b) {
        return (a.substring(1, a.length()) + b.substring(1, b.length()));

    }

    public String left2(String str) {
        return str.substring(2) + str.substring(0, 2);

    }

        public String right2(String str) {
            return str.substring(str.length() - 2) + str.substring(0, str.length() -2 );
    }

    public String theEnd(String str, boolean front)
    {
        int e = front == false ? 1 : 0;
        if (e == 1)
        {
            return str.substring(str.length() - 1);
        } else
        {
            return str.substring(0, 1);
        }

    }

    public String withouEnd2(String str) {
        if (str.length() <= 2)
        {
            return "";
        }
            return str.substring(1, str.length() - 1);

    }

    public String middleTwo(String str) {
        int d = str.length();
        if (d <= 2)
        {
            return str;
        }
        return str.substring((d/2) - 1, (d / 2) + 1);

    }

    public boolean endsLy(String str)
    {
        if (str.length() > 1 && str.substring(str.length() - 2).equals("ly"))
        {
            return true;
        }
        return false;
    }

    public String nTwice(String str, int n) {
        return str.substring(0, n) + str.substring(str.length() - n);

    }

    public String twoChar(String str, int index) {
        int b = str.length();

        if (b == 2 || b - index < 2 || index <= 0)
        {
            return str.substring(0, 2);
        }
        return str.substring(index, index + 2);


    }

    public String middleThree(String str) {
        int difference = str.length() - 3;
        if (difference <= 0)
        {
            return str;
        }
        return str.substring(difference / 2, (difference / 2) + 3);


    }

    public boolean hasBad(String str)
    {
        String test = "bad";
        if (str.length() < 3){
            return false;
        } else if (str.substring(0, 3).equals(test) || str.substring(1, 4).equals(test))
        {
            return true;
        }
            return false;
    }

    public String atFirst(String str)
    {
        if (str.length() >= 2)
        {
            return str.substring(0, 2);
        } else if (str.length() == 1)
        {
            return str.substring(0, 1) + "@";
        } else
        {
            return "@@";

        }
    }

    public static void main(String[] args)
    {

        FizzBuzz one = new FizzBuzz();
        System.out.println(one.fizzString("dib"));
        System.out.println(one.fizzString("piss"));


    }

}
