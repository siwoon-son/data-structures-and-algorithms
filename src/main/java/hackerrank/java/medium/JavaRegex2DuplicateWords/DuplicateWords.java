package hackerrank.java.medium.JavaRegex2DuplicateWords;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.hackerrank.com/challenges/duplicate-word
public class DuplicateWords {

    public static void main(String[] args) {

        // my code
        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        // end

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());
        
        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);
            
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                // my code
                input = input.replaceAll(m.group(), m.group(1));
                // end
            }
            
            // Prints the modified sentence.
            System.out.println(input);
        }
        
        in.close();
    }
}
