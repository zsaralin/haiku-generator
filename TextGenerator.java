/**
 * Text Generator --- generates text for the haikus to be made from (using markov chains)
 * @author    Saralin Zassman
 */
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextGenerator {

    /*generates sequence of words based on text file provided*/
    public static String generateText() throws IOException {
        try {
            String fp = "poem.txt";
            return MarkovChain.markov(fp, 2, 600);
        }
        catch(NullPointerException ne){
            return null;
        }
    }

    /*returns the sequence of words generated by the MarkovChain class as a List<String>, where each word occupies a
    * separate entry in the list*/
    public static List<String> generateList() throws IOException {
        String markovText = generateText();
        while (markovText == null){
            markovText = generateText();
        }
        //in preparation for the addComma method, replace each new line character with the string "NEWLINE"
        markovText = markovText.replaceAll("\\n", "NEWLINE");
        List<String> list = new ArrayList<String>(Arrays.asList(markovText.split("\\s+")));
        addComma(list);
        list.removeAll(Arrays.asList("", null)); //remove all empty entries in the list
        return list;
    }

    /*adds a comma to the end of every line without punctuation to mark the end of a phrase.
    this is useful for the LineChecker class, which labels a line as suitable for the end of a
    phrase if the line ends with a comma*/
    public static void addComma(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            //if the word/character at index i begins with "NEWLINE", the previous word is the end of a line
            if (list.get(i).matches("^NEWLINE.*")) {
                list.set(i, list.get(i).replace("NEWLINE", ""));
                //if previous word does not end in punctuation
                if (!list.get(i-1).isEmpty() && !(list.get(i - 1).matches(".*[.,?,!;:-]$"))) {
                    //add a comma to the end of the word
                    list.set(i - 1, list.get(i - 1).concat(","));
                }
            }
        }
    }

}