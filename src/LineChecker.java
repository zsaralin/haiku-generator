/**
 * LineChecker --- run a series of tests on a potential line
 * to determine whether the line is fit to be in final haiku
 * @author    Saralin Zassman
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineChecker {
    //words that the first line CANNOT start with
    private static ArrayList<String> badFirst = new ArrayList<String>(Arrays.asList("And", "Also", "Or"));
    //word that the last line CANNOT end with
    private static ArrayList<String> badLast = new ArrayList<String>(Arrays.asList("she", "he", "they", "a", "an", "of", "and", "my",
            "your", "i", "the", "this", "we", "nor", "or", "never", "because", "with", "with", "when", "could", "would", "he'd", "she'd", "of"));

    //return true if line is of the proper form, based on lineNumber in the haiku
    public static boolean lineCheck(List<String> arrWords, int lineNumber, int i) {
        switch (lineNumber) {
            case 1:
                return startHaiku(arrWords.get(0)) && endHaiku(arrWords.get(i));
            case 2:
            case 3:
                return endHaiku(arrWords.get(i));
            default:
                return false;
        }
    }

    /*determines whether the line can form the beginning of a haiku*/
    public static boolean startHaiku(String word) {
        //return true if line does not have an awkward first word
        // and line begins with an upper case letter
        return !badFirst.contains(word) && Character.isUpperCase(word.charAt(0));
    }

    /*determines whether the line can form the end of a haiku*/
    public static boolean endHaiku(String word) {
        //returns true if line does not have an awkward last word
        // and line can be considered the end of a phrase/sentence
        return !badLast.contains(word.toLowerCase()) && word.matches(".*[.!?;,]$");
    }
}
