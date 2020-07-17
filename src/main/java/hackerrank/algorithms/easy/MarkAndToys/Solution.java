package hackerrank.algorithms.easy.MarkAndToys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        // k 금액으로 살 수 있는 장난감의 최대 수를 반환한다.

        // 장난감 가격을 정렬한다.
        Arrays.sort(prices);

        // 장난감 수를 0으로 초기화한다.
        int nOfToys = 0;
        // 정렬된 가격 순서대로,
        for (int p: prices) {
            // 현재 장난감을 살 수 있다면,
            if (p <= k) {
                // 소지금을 줄이고,
                k -= p;
                // 장난감 수를 늘린다.
                nOfToys++;
            }
            // 장난감을 더 이상 살 수 없다면,
            else {
                // 더 이상 확인하지 않는다.
                break;
            }
        }

        return nOfToys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
