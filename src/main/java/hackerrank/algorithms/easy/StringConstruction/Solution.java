package hackerrank.algorithms.easy.StringConstruction;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stringConstruction function below.
    static int stringConstruction(String s) {
        // 문자열 s로부터 문자열 b로 복사할 때,
        // 새로 추가되는 문자열이 b의 부분문자열이면 cost가 0이지만,
        // b의 부분문자열이 아니면 하나의 문자만 추가하고 cost가 1 발생한다.
        // 이때 복사하는 최소 cost를 반환한다.

        // 이 문제는 모든 부분문자열을 확인할 필요가 없으며,
        // 추가될 문자가 b의 부분문자인지 확인하여 해결할 수 있다.
        // 이를 쉽게, 방문한 문자의 방문 여부를 기록하면 된다.

        // cost를 0으로 초기화한다.
        int cost = 0;

        // 영문자의 방문여부를 기록한다.
        boolean[] alphabets = new boolean[26];
        for (char c: s.toCharArray()) {
            // 이전에 방문한 문자가 아니면,
            if (!alphabets[c - 'a']) {
                // 방문을 기록하고,
                alphabets[c - 'a'] = true;
                // 비용을 1 증가시킨다.
                cost++;
            }
        }

        return cost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = stringConstruction(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
