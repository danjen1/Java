 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
 
public class WordsInAlphabeticalOrder {
 
       public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // create here an ArrayList
        ArrayList<String> words = new ArrayList<String>();
        String word;
        while (true) {
            System.out.println("Type a word: ");
            word = reader.nextLine();
            if (word.isEmpty()){
                Collections.sort(words);
                System.out.println("You typed the followign words: ");
                for (String i : words){
                    System.out.println(i);
                }
                break;
            }
            words.add(word);
        }
        
    }
}
 