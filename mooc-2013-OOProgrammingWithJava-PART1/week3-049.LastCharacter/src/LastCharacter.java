import java.util.Scanner;
 
 
public class LastCharacter {
 
 
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Type your name: ");
        String name = reader.nextLine();
        System.out.println("Last Character: " + lastCharacter(name));
    }
    
    public static char lastCharacter(String text){
        int len = text.length() - 1;
        return text.charAt(len);
    }
}
 