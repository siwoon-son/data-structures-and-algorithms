package algorithms.easy.DivisibleSumPairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        // 정수 배열 ar에서 두 원소의 합이 k로 나뉘는 경우의 개수를 센다.
        // 개수를 저장할 변수 count를 초기화한다.
        int count = 0;

        // 두 원소의 첫 번째 인덱스 i는 [0, n-1) 범위로 이동한다.
        for (int i=0; i<n-1; i++) {
            // 두 원소의 두 번째 인덱스 j는 [i+1, n) 범위로 이동한다.
            for (int j=i+1; j<n; j++) {
                // 두 원소의 합이 k로 나누어 떨어지는 경우를 센다.
                if ((ar[i] + ar[j]) % k == 0)
                    count ++;
            }
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = divisibleSumPairs(n, k, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
