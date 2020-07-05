package hackerrank.algorithms.easy.ModifiedKaprekarNumbers;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kaprekarNumbers function below.
    static void kaprekarNumbers(int p, int q) {
        // [p, q] 범위의 modified kaprekar number를 출력한다.
        // 이는 n*n을 left와 right(n 길이)로 나누고, left + right = n인 수룰 의미한다.
        // modified kaprekar number가 없을 경우를 대비한 flag를 생성한다.
        boolean exists = false;
        // p부터 q까지 반복한다.
        for (int i=p; i<=q; i++) {
            // kaprekar number인지 확인한다.
            if (isKaprekarNumber(i)) {
                exists = true;
                System.out.print(i + " ");
            }
        }

        if (!exists) System.out.println("INVALID RANGE");
    }
    private static boolean isKaprekarNumber(int number) {
        // number가 kaprekar number인지 확인한다.

        // 제곱 값을 분리하는 기준으로, number보다 크며 가장 작은 10의 제곱값을 계산한다.
        int nearest10Squares = 1;
        for (int copy = number; copy > 0; copy /= 10) {
            nearest10Squares *= 10;
        }

        // 큰 숫자를 대비하여 long 타입으로 제곱한다.
        long powered = (long) number * number;
        // 제곱값을 left와 right를 분리한다.
        long left = powered / nearest10Squares;
        long right = powered % nearest10Squares;

        return number == left + right;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        kaprekarNumbers(p, q);

        scanner.close();
    }
}
