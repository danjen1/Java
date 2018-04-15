public class Warmups2
{
    public String stringTimes(String str, int n)
    {
        String result = "";
        for (int i = 0; i < n; i++)
        {
            result += str;
        }
        return result;
    }

    public String frontTimes(String str, int n)
    {
        int f = 3;
        if (f > str.length())
        {
            f = str.length();
        }
        String front = str.substring(0, f);

        String result = "";
        for (int i = 0; i < n; i++)
        {
            result += front;
        }
        return result;
    }

    int countXX(String str)
    {
        int count = 0;
        for (char i = 0; i < str.length() - 1; i++)
        {
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x')
            {

                count++;
            }
        }
        return count;
    }

    boolean doubleX(String str)
    {
        int i = str.indexOf("x");
        if (i == -1)
        {
            return false; // no "x" at all
        }
        // Is char at i+1 also an "x"?
        if (i + 1 >= str.length())
        {
            return false; // check i+1 in bounds?
        }
        return str.substring(i + 1, i + 2).equals("x");
    }

    public String stringBits(String str)
    {
        String every = "";

        for (int i = 0; i < str.length(); i += 2)
        {
            every += str.substring(i, i + 1);

        }
        return every;
    }

    public String stringSplosion(String str)
    {
        int x = str.length();
        String add;
        String result = "";

        for (int i = 0; i < str.length(); i++)
        {
            add = str.substring(0, i + 1);
            result = result + add;
        }

        return result;
    }

    public int last2(String str)
    {
        if (str.length() < 2)
            return 0;

        String last = str.substring(str.length() - 2);
        int count = 0;

        for (int i = 0; i < str.length() - 2; i++)
        {
            if (str.substring(i, i + 2).equals(last))
            {
                count++;
            }
        }
        return count;
    }

    public int arrayCount9(int[] nums)
    {
        int count = 0;

        for (int i : nums)
        {
            if (i == 9)
            {
                count++;
            }
        }
        return count;
    }

    public boolean arrayFront9(int[] nums)
    /*Given an array of ints, return true if one of the first 4
     elements in the array is a 9. The array length may be less than 4.*/
    {
        boolean result = false;
        int len = 3;
        int targetNum = 9;

        if (nums.length < len)
        {
            len = nums.length;
        }
        for (int i = 0; i < len; i++)
        {
            if (targetNum == nums[i])
            {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean array123(int[] nums)
    {
        // Note: iterate < length-2, so can use i+1 and i+2 in the loop
        for (int i = 0; i < (nums.length - 2); i++)
        {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3)
            {
                return true;
            }
        }
        return false;
    }


    /*Given 2 strings, a and b, return the number of the positions where they contain the
    same length 2 substring. So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and
     "az" substrings appear in the same place in both strings.*/
    public int stringMatch(String a, String b)
    {
        int count = 0;
        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len - 1; i++)
        {
            String subA = a.substring(i, i + 2);
            String subB = b.substring(i, i + 2);

            if (subA.equals(subB))
            {
                count++;
            }
        }
        return count;
    }

    /*Given a string, return a version where all the "x" have been removed. Except an "x" at
    the very start or end should not be removed.*/
    public String stringX(String str)
    {
        String result = "";
        for (int i = 0; i < str.length(); i++)
        {
            // Only append the char if it is not the "x" case
            if (!(i > 0 && i < (str.length() - 1) && str.substring(i, i + 1).equals("x")))
            {
                result = result + str.substring(i, i + 1); // Could use str.charAt(i) here
            }
        }
        return result;
    }

    public String altPairs(String str)
    {
        String result = "";

        // Run i by 4 to hit 0, 4, 8, ...
        for (int i = 0; i < str.length(); i += 4)
        {
            // Append the chars between i and i+2
            int end = i + 2;
            if (end > str.length())
            {
                end = str.length();
            }
            result = result + str.substring(i, end);
        }
        return result;
    }

/*
Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are
removed,  but the "a" can be any char. The "yak" strings will not overlap.*/
    public String stringYak(String str)
    {
        String result = "";
        for (int i = 0; i < str.length(); i++)
        {
            // Look for i starting a "yak" -- advance i in that case
            if (i + 2 < str.length() && str.charAt(i) == 'y' && str.charAt(i + 2) == 'k')
            {
                i = i + 2;
            } else
            { // Otherwise do the normal append
                result = result + str.charAt(i);
            }
        }
        return result;
    }
    /*
Given an array of ints, return the number of times that two 6's are next to each other
in the array. Also count instances where the second "6" is actually a 7.*/
    public int array667(int[] nums)
    {
        int count = 0;
        for (int i = 0; i < nums.length -1; i++)
        {
            if (nums[i] == 6 && nums[i + 1] == 6 || nums[i + 1] == 7)
            {
                count++;
            }
        }
        return count;
    }

    /*Given an array of ints, we'll say that a triple is a value appearing 3 times in a row
    in the array. Return true if the array does not contain any triples.*/
    public boolean noTriples(int[] nums)
    {
        for (int i = 0; i < nums.length - 2; i++)
        {
            int compare = nums[i];
            if (compare == nums[i + 1] && compare == nums[i + 2])
            {
                return false;
            }
        }
        return true;
    }

    /*
Given an array of ints, return true if it contains a 2, 7, 1 pattern: a value, followed
by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if
the "1" differs by 2 or less from the correct value. */
    public boolean has271(int[] nums)
    {
        // Iterate < length-2, so can use i+1 and i+2 in the loop.
        // Return true immediately when seeing 271.
        for (int i=0; i < (nums.length-2); i++)
        {
            int val = nums[i];
            if (nums[i+1] == (val+5) &&              // the "7" check
                    Math.abs(nums[i+2] - (val-1)) <= 2)  // the "1" check
            {
                return true;
            }
        }
        // If we get here ... none found.
        return false;
    }
}