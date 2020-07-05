package hackerrank.algorithms.easy.MinimumDistances;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        // Array a에서 같은 값의 숫자끼리의 index 거리 중, 가장 짧은 거리를 반환하다.
        // 현재까지의 최소 거리를 정수 최대값으로 초기화한다.
        int minDistance = Integer.MAX_VALUE;
        // Array 값과 index를 저장할 Map을 생성한다.
        // 같은 Array 값은 가장 최근 index로 대체된다.
        // Array 값이 1부터 10^5까지 너무 많아 Array가 아닌 Map을 사용한다.
        Map<Integer, Integer> numToIdx = new HashMap<>();
        for (int i=0; i<a.length; i++) {
            // Map에 Array 값이 있다면,
            if (numToIdx.get(a[i]) != null) {
                // Array 값의 index 현재 index를 차이를 최소 거리와 비교하여 대체한다.
                minDistance = Math.min(minDistance, i - numToIdx.get(a[i]));
            }
            // Map에 현재 Array 값과 index를 저장한다.
            numToIdx.put(a[i], i);
        }

        // 최소 거리가 발견되지 않으면 -1을 반환한다.
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
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

        int result = minimumDistances(a);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
