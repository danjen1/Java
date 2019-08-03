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
