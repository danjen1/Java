import java.util.Random;
 
public class PasswordRandomizer {
    int length;
    Random random = new Random();
    
    public PasswordRandomizer(int length) {
        this.length = length;
    }
 
    public String createPassword() {
        int counter = this.length;
        String password = "";
        while (counter > 0) {
            int a = this.random.nextInt(26);
            char symbol = "abcdefghijklmnopqrstuvwxyz".charAt(a);
            password += symbol;
            counter--;
        }
        return password;
    }
}
 