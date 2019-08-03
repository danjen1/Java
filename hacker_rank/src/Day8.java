import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;
public class Day8
{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map <String, Integer> phoneBook;
        phoneBook = new HashMap<String, Integer>();

        for(int i = 0; i < n; i++)
        {
            String name = in.next();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();

            if (phoneBook.containsKey(s))
            {
                System.out.println(s + "=" + phoneBook.get(s));
            } else
            {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
