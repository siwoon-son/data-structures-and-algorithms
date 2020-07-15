package hackerrank.algorithms.easy.Anagram;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the anagram function below.
    static int anagram(String s) {
        // 문자열 s의 중간을 기준으로
        // 좌측 부분문자열과 우측 부분문자열이 anagram이 되도록
        // 바꿔야할 최소 문자의 수를 반환한다.

        // 홀수개의 문자열은 나눌 수 없어 -1을 반환한다.
        if (s.length() % 2 == 1) return -1;

        // 좌측 문자열의 빈도수와 우측 문자열의 빈도수의 차이를 계산한다.
        int[] freqs = new int[26];

        // 좌측 문자열의 빈도수를 누적한다.
        for (int i=0; i<s.length()/2; i++) {
            freqs[s.charAt(i) - 'a']++;
        }

        // 우측 문자열의 빈도수를 뺀다.
        for (int i=s.length()/2; i<s.length(); i++) {
            freqs[s.charAt(i) - 'a']--;
        }

        // 좌측과 우측의 차이를 더한다.
        int nOfChanged = 0;
        for (int freq: freqs) {
            nOfChanged += Math.abs(freq);
        }

        // 하나를 바꾸면 두 개의 차이를 줄이므로,
        // 2를 나눠서 반환한다.
        return nOfChanged/2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = anagram(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
