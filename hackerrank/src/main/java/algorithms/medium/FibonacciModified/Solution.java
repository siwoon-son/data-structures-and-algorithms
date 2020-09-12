package algorithms.medium.FibonacciModified;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fibonacciModified function below.
    static BigDecimal fibonacciModified(long t1, long t2, int n) {
        // t_(i+2) = t_i + t_(i+1)^2을 만족하는 피보나치 수열 값을 반환한다.
        // 결과는 64-bit 범위를 초과할 수 있다.

        // primitive type으로는 처리할 수 없어, BigDecimal을 사용한다.
        BigDecimal fib = new BigDecimal(0);
        BigDecimal bdt1 = new BigDecimal(t1);
        BigDecimal bdt2 = new BigDecimal(t2);
        for (int i=3; i<=n; i++) {
            fib = bdt1.add(bdt2.multiply(bdt2));
            bdt1 = bdt2;
            bdt2 = fib;
        }

        return fib;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] t1T2n = scanner.nextLine().split(" ");

        int t1 = Integer.parseInt(t1T2n[0]);

        int t2 = Integer.parseInt(t1T2n[1]);

        int n = Integer.parseInt(t1T2n[2]);

        BigDecimal result = fibonacciModified(t1, t2, n);

        bufferedWriter.write(result.toString());
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
