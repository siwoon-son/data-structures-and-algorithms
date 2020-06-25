package hackerrank.algorithms.medium.SherlockAndAnagrams;

import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int cnt = 0;
        for (int size=1; size<s.length(); size++) {
            for (int i=0; i<s.length()-size; i++) {
                String s1 = s.substring(i, i+size);
                for (int j=i+1; j<s.length()-size+1; j++) {
                    String s2 = s.substring(j, j+size);
                    if (isAnagram(s1, s2))
                        cnt++;
                }
            }
        }
        return cnt;
    }

    private static boolean isAnagram(String s1, String s2) {
        List<Character> charsS1 = new ArrayList<>();
        for (char c: s1.toCharArray()) {
            charsS1.add(c);
        }
        for (char c: s2.toCharArray()) {
            if (!charsS1.contains(c)) return false;
            charsS1.remove(charsS1.lastIndexOf(c));
        }
        return charsS1.size() == 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
