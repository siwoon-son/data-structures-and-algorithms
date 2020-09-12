package java.medium.TagContentExtractor;

import java.util.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/tag-content-extractor/problem
public class TagContentExtractor {
	public static void main(String[] args){
		// my code
		final String PATTERN = "<(.+?)>([^<>]+)</\\1>";
		Pattern p = Pattern.compile(PATTERN);
		// end

		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();

          	// my code
			Matcher matcher = p.matcher(line);
			boolean isFound = false;
			while (matcher.find()) {
				System.out.println(matcher.group(2));
				isFound = true;
			}
			if (!isFound) System.out.println("None");
			// end

			testCases--;
		}
	}
}



