package hackerrank.algorithms.easy.ExtraLongFactorials;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        // 매우 큰 factorial을 계산하기 위해 BigInteger 클래스를 사용한다.
        // BigInteger 객체를 1로 초기화한다.
        BigInteger fact = new BigInteger(String.valueOf(1));
        for (int i=1; i<=n; i++) {
            // 정수 i의 BigInteger 객체와 누적곱한다.
            fact = fact.multiply(new BigInteger(String.valueOf(i)));
        }
        // 결과를 문자열로 출력한다.
        System.out.println(fact.toString());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}
