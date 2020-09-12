package algorithms.easy.UtopianTree;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the utopianTree function below.
    static int utopianTree(int n) {
        // Utopian Tree는 주기 0에 높이 1부터 성장한다.
        // 이후, 홀수 주기에는 2배씩, 짝수 주기에는 1씩 성장한다.
        // 이때 n 주기에 utopian tree의 높이를 반환한다.
        // examples)
        // period: 0 1 2 3 4  5  6  7  8  9 10  11 ...
        // height: 1 2 3 6 7 14 15 30 31 62 63 126 ...

        // 홀수-짝수 주기를 묶으면, 각각 2의 (n+3)/2 제곱에 -2와 -1로 표현할 수 있다.
        return (int) Math.pow(2, ((n+3) / 2)) - (n % 2 == 1 ? 2 : 1);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int result = utopianTree(n);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
