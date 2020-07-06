package hackerrank.algorithms.easy.ManasaAndStones;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stones function below.
    static int[] stones(int n, int a, int b) {
        // 0부터 시작하는 수가 (n-1)회 a 또는 b가 더해진다.
        // 이때 가능한 마지막 숫자들을 반환한다.

        // 테스트 케이스를 살펴보니 가능한 마지막 숫자는 다음의 형태를 따르는 등차수열이다.
        // Ai = min(a, b) * (n - 1) + abs(a - b) * (i - 1)
        // 수열은 총 n개로 구성된다. (즉, i는 1..n)
        // 단, a와 b가 같으면 a * (n-1) 하나만 갖는다.

        // a와 b가 같으면, 하나만 배열을 구성하여 반환한다.
        if (a == b) return new int[]{a * (n-1)};
        // 등차수열의 초항을 계산한다.
        int A1 = Math.min(a, b) * (n - 1);
        // 등차수열의 공차를 계산한다.
        int d = Math.abs(a - b);
        // n번 반복하며 수열을 계산한다.
        int[] ret = new int[n];
        for (int i=0; i<n; i++) {
            ret[i] = A1 + d * i;
        }

        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int a = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int b = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = stones(n, a, b);

            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
