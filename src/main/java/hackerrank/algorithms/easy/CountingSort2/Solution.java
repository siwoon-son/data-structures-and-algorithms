package hackerrank.algorithms.easy.CountingSort2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        // 계수 정렬을 위해 arr를 구성하는 정수 각각의 개수를 센다.
        // 정수 범위는 0부터 99까지로 가정하므로, 100개의 정수 배열을 만든다.
        int[] counting = new int[100];

        // arr를 순회한다.
        for (int val: arr) {
            // 값의 개수를 증가시킨다.
            counting[val]++;
        }

        // 0부터 99까지 하나씩 이동한다.
        int val = 0;
        // arr에 정렬된 값들을 하나씩 저장한다.
        for (int i=0; i<arr.length; i++) {
            // arr에 val이 없다면,
            while (counting[val] == 0) {
                // 존재하는 val까지 val을 증가시킨다.
                val++;
            }

            // 정렬된 순서대로 arr에 저장한다.
            arr[i] = val;
            // counting에서 val을 하나 제거한다.
            counting[val]--;
        }

        return arr;
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

        int[] result = countingSort(arr);

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
