
public class Smileys {

    public static void main(String[] args) {

        // Test your method at least with the following
        printWithSmileys("Meth");
        printWithSmileys("Bee");
        printWithSmileys("Mikeal");
        printWithSmileys("Bee");
        printWithSmileys("12345678910");
        printWithSmileys("123456789");
        printWithSmileys("12345678");
        printWithSmileys("1234567");
    }

    private static void printWithSmileys(String characterString) {
        int length = characterString.length();
        int termEven = length + 1;
        int termOdd = length + 2;
        String smiley = ":)";

        if (length % 2 == 0) {
            termEven = (length + 6) / 2;
            printSmiley(termEven);
            //System.out.println("");
            System.out.println(smiley + " " + characterString + " " + smiley);
            printSmiley(termEven);
        }

        if (length % 2 == 1) {
            termOdd = (length + 7) / 2;
            printSmiley(termOdd);
            //System.out.println("");
            System.out.println(smiley + " " + characterString + "  " + smiley);
            printSmiley(termOdd);
        }
    }

    private static void printSmiley(int length) {
        String smiley = ":)";
        for (int i = 0; i < length; i++) {
            System.out.print(smiley);
        }
        System.out.println("");
    }
}
/*print("Daniel is amazing", 3);
        
        Scanner in = new Scanner(System.in);
        System.out.println("Enter characterString: ");
        String characterString = in.nextLine();
        
        printStars(characterString.length());
        System.out.println(characterString);
        printStars(characterString.length());
    
        Book senseAndSensibility = new Book("Sense and Sensibility", 1811);
        Book prideAndPrejudice = new Book("Pride and Prejudice", 1813);
        
        System.out.println(senseAndSensibility.getName());
        System.out.println(prideAndPrejudice.getName());
        
        Scanner in = new Scanner(System.in);
        UserInterface inter = new UserInterface(in);
        
        inter.start();
        
    }

    public static void print(String characterString, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(characterString);
        }
    }
    
    public static void printStars(int times){
        String star = "*";
        for (int i = 1; i < times; i++){
            System.out.print(star);
        }
        System.out.println();
    }
 */
