package algorithms.easy.MinimumAbsoluteDifferenceInAnArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        // 배열 arr에서 임의의 두 원소가 가질 수 있는 가장 작은 차이를 반환한다.

        // straightforward 방법은 모든 원소 간의 차이를 비교하고, 가장 작은 차이를 반환한다.
        // 하지만, 이 방법은 n개의 원소에서 O(n^2)의 복잡도를 요구한다.

        // 이를 더 간단히 하여, 정렬된 배열에서는 연속된(이웃하는) 원소만 비교하면 된다.
        // 즉, 정렬을 위해 O(nlog(n))의 복잡도와 비교를 위해 o(n)이 필요하여 개선된다.

        // 배열을 먼저 정렬한다.
        Arrays.sort(arr);

        // 연속된(이웃하는) 원소만 비교하여 최소값을 저장한다.
        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length-1; i++) {
            min = Math.min(min, arr[i+1] - arr[i]);
        }

        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
