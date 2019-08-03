public class Strings
{

    public String lastChars(String a, String b)
    {
        if (a.length() == 0)
        {
            a = "@";
        }
        if (b.length() == 0)
        {
            b = "@";
        }
        return a.substring(0, 1) + b.substring(b.length() - 1, b.length());
    }


    public String conCat(String a, String b)
    {

        if (a.length() == 0 || b.length() == 0)
            return a + b;
        if ((a.substring(a.length() - 1, a.length())).equals(b.substring(0, 1)))
            return a + b.substring(1, b.length());
        else
            return a + b;
    }

    public String lastTwo(String str)
    {
        if (str.length() < 2)
        {
            return str;
        } else if (str.length() == 2)
        {
            return str = str.substring(1, 2) + str.substring(0, 1);
        }
        String a = str.substring(str.length() - 1, str.length());
        String b = str.substring(str.length() - 2, str.length() - 1);
        return str = str.substring(0, str.length() - 2) + a + b;
    }

    public String seeColor(String str)
    {
        if (str.startsWith("red"))
        {
            return "red";
        }
        if (str.startsWith("blue"))
        {
            return "blue";
        }
        return "";
    }

    public boolean frontAgain(String str)
    {
        if (str.length() == 2)
        {
            return true;
        }
        if (str.length() < 2)
        {
            return false;
        }
        return str.substring(0, 2).equals(str.substring(str.length() - 2));
    }

    public String minCat(String a, String b)
    {
        int one = a.length();
        int two = b.length();
        int three = a.length() - b.length();
        int four = b.length() - a.length();
        if (one > two)
        {
            return a.substring(three) + b;
        } else if (two > one)
        {
            return a + b.substring(four);
        }
        return a + b;
    }

    public String extraFront(String str)
    {
        if (str.length() < 2)
        {
            return str + str + str;
        }
        return str.substring(0, 2) + str.substring(0, 2) + str.substring(0, 2);
    }

    public String without2(String str)
    {
        if (str.length() < 2)
        {
            return str;


        } else if (str.substring(0, 2).equals(str.substring(str.length() - 2)))
        {
            return str.substring(2);
        }
        return str;
    }

    public String deFront(String str)
    {
        int len = str.length();
        String temp = "";
        for (int i = 0; i < len; i++)
            if (i == 0 && str.charAt(i) == 'a')
            {
                temp += 'a';
            } else if (i == 1 && str.charAt(i) == 'b')
            {
                temp += 'b';
            } else if (i > 1)
            {
                temp += str.charAt(i);
            }
        return temp;
    }

    public String startWord(String str, String word)
    {
        String x = word.substring(1);
        if (str.startsWith(x, 1))
        {
            return str.substring(0, word.length());
        } else
        {
            return "";
        }
    }

    public String startWord1(String str, String word) {
        if(str.length() >= word.length() &&
                str.substring(1, word.length()).equals(word.substring(1)))
            return str.substring(0, word.length());

        return "";
    }


    public String withoutX(String str) {

        if (str.length() == 0)
            return str;
        if (str.length() == 1){
            if (str.charAt(0) == 'x')
                return "";
            else
                return str;
        }
        if (str.charAt(0) == 'x')
            str = str.substring(1,str.length());
        if (str.charAt(str.length()-1) == 'x')
            str = str.substring(0,str.length()-1);
        return str;
    }







    public static void main(String[] args)
    {
        Strings one = new Strings();
        System.out.println(one.minCat("Hello", "Hi"));
        System.out.println(one.minCat("java", "Hello"));
        System.out.println(one.minCat("java", "java"));
        System.out.println(one.minCat("", ""));

        System.out.println(one.deFront("ab"));
        one.startWord("readaser", "Hi");



    }
}


