package algorithms.easy.GameOfThrones1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        // 문자열 s의 anagram으로 palindrome을 구성할 수 있을까?

        // 모든 문자의 빈도수를 계산한다.
        int[] freqs = new int[26];
        for (char c: s.toCharArray()) {
            freqs[c - 'a']++;
        }

        // 홀수 개의 수를 센다.
        int nOfOdds = 0;
        for (int f: freqs) {
            if (f % 2 == 1) nOfOdds++;
        }

        // 홀수 개가 2개 이상이면 불가능하다.
        if (nOfOdds > 1) return "NO";
        // 홀수 개가 1이면서, 문자열의 길이가 홀수면 가능하다.
        if (nOfOdds == 1 && s.length() % 2 == 1) return "YES";
        // 문자열이 짝수 개의 문자로만 이루어졌다면 가능하다.
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        System.out.println(result);

        scanner.close();
    }
}
