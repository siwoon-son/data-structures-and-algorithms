package hackerrank.algorithms.easy.Quicksort1Partition;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the quickSort function below.
    static int[] quickSort(int[] arr) {
        // Quick sort에서 pivot의 위치를 잡는 divide를 구현한다.
        // 첫 번째 원소를 pivot이라 가정하고,
        int pivot = 0;
        for (int i=1; i<arr.length; i++) {
            // 첫 번째 값보다 현재 값이 더 작으면,
            if (arr[i] < arr[0]) {
                // pivot을 하나 증가시키고,
                pivot++;
                // pivot 위치와 현재 값을 swap한다.
                swap(arr, i, pivot);
            }
        }
        // 반복이 끝나면 pivot 자리와 첫 번째 값을 swap한다.
        swap(arr, 0, pivot);

        return arr;
    }

    private static void swap(int[] data, int i, int j) {
        if (i == j) return ;
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
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

        int[] result = quickSort(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
