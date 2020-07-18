package hackerrank.algorithms.easy.LonelyInteger;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the lonelyinteger function below.
    static int lonelyinteger(int[] a) {
        // 배열 a에는 숫자가 한 번 또는 두 번씩 존재한다.
        // 한 번만 존재하는 숫자는 하나만 있다.
        // 한 번만 존재하는 숫자를 반환한다.

        // 이 문제는 xor로 쉽게 계산할 수 있다.
        // 두 번 존재하는 숫자는 xor을 통해 존재하지 않는 것과 같다.
        int xor = 0;
        for (int num: a) {
            xor ^= num;
        }
        return xor;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = lonelyinteger(a);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
