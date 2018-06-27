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

    public static void main(String[] args)
    {

        FizzBuzz one = new FizzBuzz();
        System.out.println(one.fizzString("dib"));
        System.out.println(one.fizzString("piss"));

    }

}
