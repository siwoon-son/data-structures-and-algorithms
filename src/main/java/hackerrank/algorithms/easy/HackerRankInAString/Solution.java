package hackerrank.algorithms.easy.HackerRankInAString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hackerrankInString function below.
    static String hackerrankInString(String s) {
        // 문자열 s에 "hackerrank"가 순서대로 포함되는지 확인한다.
        // "hackerrank"를 문자 배열로 변환한다.
        char[] hackerrank = "hackerrank".toCharArray();

        // "hackerrank"의 인덱스를 0으로 초기화한다.
        int idx = 0;
        // 문자열 s를 순회한다.
        for (char c: s.toCharArray()) {
            // 현재 문자가 "hackerrank"의 idx 위치에 있는 값과 같으면 idx를 1 증가시키는데,
            // idx가 hackerrank의 길이와 같으면,
            // YES를 반환한다.
            if (c == hackerrank[idx] && ++idx == hackerrank.length) return "YES";
        }

        // 반복이 끝나면 포함되지 않으므로 NO를 반환한다.
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = hackerrankInString(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
