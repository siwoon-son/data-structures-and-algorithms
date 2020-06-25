package hackerrank.java.easy.JavaAnagrams;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-anagrams/problem
public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;
        a = a.toLowerCase(); b = b.toLowerCase();
        int[] freqs = new int[26];
        for (char c: a.toCharArray()) {
            freqs[c-'a']++;
        }
        for (char c: b.toCharArray()) {
            freqs[c-'a']--;
            if (freqs[c-'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}