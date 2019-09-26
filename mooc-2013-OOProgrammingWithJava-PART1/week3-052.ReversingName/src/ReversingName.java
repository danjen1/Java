import java.util.Scanner;
 
public class ReversingName {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name");
        String name = reader.nextLine();
            int i = 0;
            int len = name.length() - 1;
            System.out.print("In reverse order: ");
            while (i < name.length()){
                System.out.print(name.charAt(len - i));
                i++;
            }
        System.out.println("");
    }
    }
 