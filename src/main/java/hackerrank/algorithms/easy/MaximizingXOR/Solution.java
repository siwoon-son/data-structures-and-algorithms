package hackerrank.algorithms.easy.MaximizingXOR;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximizingXor function below.
    static int maximizingXor(int l, int r) {
        // l <= a <= b <= r을 만족하는 (a, b)에 대해,
        // a xor b의 최대값을 반환한다.

        // 최대값을 0으로 초기화한다.
        int maxXor = 0;

        // 모든 a와 b에 대해,
        for (int a = l; a <= r; a++) {
            for (int b = a; b <= r; b++) {
                // xor 최대값을 계산한다.
                maxXor = Math.max(maxXor, a ^ b);
            }
        }

        return maxXor;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int l = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int r = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = maximizingXor(l, r);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
