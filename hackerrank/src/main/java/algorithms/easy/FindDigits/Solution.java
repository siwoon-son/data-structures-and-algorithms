package algorithms.easy.FindDigits;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findDigits function below.
    static int findDigits(int n) {
        // 정수 n의 각 자리수가 n을 나누었을때, 나머지가 0인 자리수의 개수를 반환한다.
        // 정수 n을 유지하고, 자리수를 추출하기 위해 n을 복사한다.
        int copy = n;
        // 개수를 저장할 변수를 초기화한다.
        int count = 0;

        // 복사본으로부터 자리수를 하나씩 추출하며 반복한다.
        while (copy > 0) {
            // 1의 자리를 추출한다.
            int digit = copy % 10;
            // 1의 자리를 버린다.
            copy /= 10;
            // 1의 자리가 0이면 넘어간다.
            if (digit == 0) continue;
            // 자리수로 정수 n을 나누고, 나머지가 0이면 개수를 증가시킨다.
            if (n % digit == 0) count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = findDigits(n);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
