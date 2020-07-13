package hackerrank.algorithms.easy.FlippingBits;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingBits function below.
    static long flippingBits(long n) {
        // 32비트 양의 정수 n의 모든 비트를 flip한다.
        // 이는 다음과 같은 문제 예시에서 쉽게 답을 유추할 수 있다.
        // e.g. 4 -> 4294967291
        // e.g. 0 -> 4294967295
        // 즉, n이 커질수록 flip의 결과는 감소한다.
        // 따라서, 가장 작은 n의 flip은 가장 큰 flip 결과이다.
        // 이는 다음과 같이 계산된다.
        return 4294967295L - n;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
