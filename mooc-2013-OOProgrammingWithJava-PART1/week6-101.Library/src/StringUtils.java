public class StringUtils {
 
    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
 
        word = word.trim();
        searched = searched.trim();
 
        word = word.toUpperCase();
        searched = searched.toUpperCase();
 
        return word.contains(searched);
    }
}