package hackerrank.algorithms.easy.IceCreamParlor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        // 아이스크림 가격이 적힌 arr로부터 m원으로 두 개의 서로 다른 아이스크림을 구매한다.
        // 즉, i-번째 아이스크림 가격과 j-번째 아이스크림 가격의 합이 m을 만족하는 (i, j)를 반환한다.

        // i-번째 아이스크림을 구매할 경우의 잔돈을 (잔돈, i) 구조로 맵에 저장한다.
        Map<Integer, Integer> changes = new HashMap<>();

        for (int i=0; i<arr.length; i++) {
            // i-번째 아이스크림 가격이 가진 돈보다 많으면 무시한다.
            if (arr[i] >= m) continue;
            // i-번째 아이스크림의 가격과 같은 금액의 잔돈(키)이 맵에 있으면,
            if (changes.containsKey(arr[i])) {
                // 기존에 구매한 아이스크림 번호와 현재의 아이스크림 번호를 반환한다.
                // (1을 더하는 이유는 1-기반 인덱스이기 때문이다.)
                return new int[]{changes.get(arr[i]), i+1};
            }

            // i-번째 아이스크림의 가격과 같은 금액의 잔돈(키)이 맵에 없으면,
            // 현재 아이스크림을 살 경우의 잔돈과 아이스크림 번호를 맵에 저장한다.
            changes.put(m - arr[i], i+1);
        }

        // 문제에서 반드시 하나의 답이 존재하므로,
        // 이 영역은 도달하지 않는다.
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);

            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.println();
        }

        scanner.close();
    }
}
