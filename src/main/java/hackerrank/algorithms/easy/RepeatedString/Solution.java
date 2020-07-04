package hackerrank.algorithms.easy.RepeatedString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        // 문자열 s의 문자들이 n번 반복될 때, 문자 'a'의 개수를 반환한다.
        // step 1. 문자열 s가 끝까지 반복되는 횟수와 s 내의 'a' 갯수를 곱한다.
        // 반복 횟수 n을 문자열 길이로 나눠 몫을 계산한다.
        long repeated = n / s.length();
        // 문자열 내의 'a' 갯수를 계산한다.
        int nOfLetterA = 0;
        for (char c: s.toCharArray()) {
            if (c == 'a') nOfLetterA++;
        }
        // 반복 횟수와 'a' 갯수를 곱한다.
        repeated *= nOfLetterA;

        // step 2. 반복이 문자열 s의 중간에 끝나는 경우, 끝날 때까지의 'a' 갯수를 더한다.
        // 반복 횟수 n을 s의 길이로 나눠 나머지를 계산하고, 그 때까지의 'a' 갯수를 더한다.
        for (int i=0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a') repeated++;
        }

        return repeated;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
