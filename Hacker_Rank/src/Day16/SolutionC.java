package Day16;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolutionC {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();

        try
        {
            int isIt = Integer.parseInt(S);
            System.out.println(isIt);
        } catch (Exception ex)
        {
            System.out.println("Bad String");
        }
    }
}