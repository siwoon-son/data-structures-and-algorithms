package algorithms.easy.SherlockandSquares;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the squares function below.
    static int squares(int a, int b) {
        // [a, b] 사이에 제곱 수의 갯수를 반환한다.
        // a부터 b까지 반복하며 제곱 수를 판별하는 방법은 많은 시간이 필요하다.
        // 따라서, a의 제곱근과 b의 제곱근 사이의 정수 갯수를 계산한다.
        // a의 제곱근보다 큰 정수를 계산한다.
        a = (int) Math.ceil(Math.sqrt(a));
        // b의 제곱근보다 작은 정수를 계산한다.
        b = (int) Math.floor(Math.sqrt(b));

        // a와 b 사이의 갯수를 반환한다.
        return b - a + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] ab = scanner.nextLine().split(" ");

            int a = Integer.parseInt(ab[0]);

            int b = Integer.parseInt(ab[1]);

            int result = squares(a, b);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
