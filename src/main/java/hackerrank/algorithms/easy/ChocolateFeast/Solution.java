package hackerrank.algorithms.easy.ChocolateFeast;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the chocolateFeast function below.
    static int chocolateFeast(int n, int c, int m) {
        // c 가격에 초콜릿을 파는데 m 개의 포장지를 가져오면 초콜릿을 하나 더 주는 상점에서
        // n으로 구매할 수 있는 초콜릿의 수를 반환한다.
        // 먼저, n으로 직접 구매할 초콜릿의 수를 계산한다.
        int count = n / c;
        int wrappers = n / c;
        // 포장지 수가 m 보다 많으면,
        while (wrappers >= m) {
            // 포장지로 교환한 초콜릿 수를 증가시키고,
            count += wrappers / m;
            // 새로운 초콜릿 포장지와 기존에 남은 포장지를 더한다.
            wrappers = wrappers / m + wrappers % m;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] ncm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(ncm[0]);

            int c = Integer.parseInt(ncm[1]);

            int m = Integer.parseInt(ncm[2]);

            int result = chocolateFeast(n, c, m);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
