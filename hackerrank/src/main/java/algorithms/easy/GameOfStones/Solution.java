package algorithms.easy.GameOfStones;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfStones function below.
    static String gameOfStones(int n) {
        // n개의 돌 중에서 2 또는 3 또는 5개씩 뺄 수 있을 때,
        // 더 이상 가져갈 수 없으면 패배한다.
        // 첫 번째와 두 번째 순서 중 승자를 가린다.

        // n이 1부터 순서대로 승패를 확인하면 다음과 같다.
        // 1 -> Second
        // 2 -> First
        // 3 -> First
        // 4 -> First
        // 5 -> First
        // 6 -> First
        // 7 -> Second
        // 8 -> Second
        // 9 -> First
        // 10 -> First
        // 11 -> First
        // 12 -> First
        // 13 -> First
        // 14 -> Second
        // 15 -> Second
        // 이러한 패턴으로부터,
        // "n을 7로 나눈 나머지가 0 또는 1이면 Second가 승리한다."
        // 라는 규칙을 찾을 수 있다.
        return n % 7 == 0 || n % 7 == 1 ?
                "Second" : "First";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = gameOfStones(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
