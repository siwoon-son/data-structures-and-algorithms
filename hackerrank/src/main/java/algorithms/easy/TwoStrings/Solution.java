package algorithms.easy.TwoStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        // 두 문자열에 공통된 문자가 있으면 "YES", 없으면 "NO"를 반환한다.

        // 첫 번째 문자열에 포함된 문자의 여부를 기록한다.
        boolean[] existsCharacter = new boolean[26];
        for (char c: s1.toCharArray()) {
            existsCharacter[c - 'a'] = true;
        }

        // 두 번째 문자열을 순회하면서,
        for (char c: s2.toCharArray()) {
            // 공통된 문자가 있으면 "YES"를 반환한다.
            if (existsCharacter[c - 'a']) return "YES";
        }

        // 이 영역에 도달하면 공통된 문자가 없다.
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }
}
