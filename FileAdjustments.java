/**
 * FileAdjustments --- create a copy of the original text file but without any titles or unnecessary punctuations
 * @author    Saralin Zassman
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileAdjustments {
    private File inputFile; //original file
    private File outputFile; //file with adjustments

    public FileAdjustments(String input, String output){
        inputFile = new File(input);
        outputFile = new File(output);
    }

    /*write to outputFile*/
    public void writeFile() throws IOException {
        Scanner scLine = new Scanner(inputFile);
        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
        while (scLine.hasNextLine()) {
            String line = scLine.nextLine();
            Scanner scWord = new Scanner(line);
            while (scWord.hasNext()) {
                String string = scWord.next(); //single string
                line = line.replace(string, removeTitle(string)) //remove titles
                         .replace(string, removePunctuation(string)) //remove unnecessary punctuation
                         .trim().replaceAll("\\s{2,}", " "); //remove multiple white spaces
            }
            //write altered line to new text file
            bw.write(line);
            bw.newLine();
        }
        bw.close();
    }

    /*removes unnecessary characters*/
    private static String removePunctuation(String input) {
        //remove apostrophes, excluding those before or after s
        input = input.replace(",'", ",") //comma followed by an apostrophe
                .replace(".'", ".") //period followed by an apostrophe
                .replaceAll("[()\\[\\]]|^[']|[']$", ""); //brackets, and apostrophe at beginning or end of a string
        return input;
    }

    /*removes poem titles (which are typically in all CAPITAL LETTERS)*/
    private static String removeTitle(String input) {
        //if string is in ALL CAPS (2 or more consecutive upper case letters)
        if (input.replaceAll("\\p{Punct}", "").matches("[A-Z]{2,}")) {
            //replace string with empty string
            return "";
        } else {
            return input;
        }
    }

    public static void main(String[] args) throws IOException {
        FileAdjustments test = new FileAdjustments(".txt", ".txt");
        test.writeFile();
    }
}

