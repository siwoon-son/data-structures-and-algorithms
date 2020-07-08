package hackerrank.algorithms.easy.InsertionSortPart1;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        // 0 인덱스부터 n-2 인덱스까지 정렬된 배열 arr에 새로운 값 arr[n-1]을 삽입 정렬한다.
        // arr[n-1]을 복사한다.
        int inserted = arr[n-1];

        // 새로운 값의 위치를 0으로 초기화한다.
        // 배열 중간에 위치를 찾았다면 해당 위치를, 모든 배열을 순회해도 못찾으면 첫 번째 자리이다.
        int pos = 0;
        // n-2부터 0까지 반복한다.
        for (int i=n-2; i>=0; i--) {
            // 새로운 값의 위치를 찾으면,
            if (arr[i] < inserted) {
                // 위치를 저장하고 반복을 벗어난다.
                pos = i+1;
                break;
            }
            // 새로운 값이 여전히 더 작으면,
            else {
                // 직전 값을 shift한다.
                arr[i+1] = arr[i];
            }
            printArray(arr);
        }
        // 새로운 값을 저장한다.
        arr[pos] = inserted;
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}
