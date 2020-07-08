package hackerrank.algorithms.easy.InsertionSortPart2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
        // 삽입 정렬을 구현한다.
        // 0 인덱스는 정렬되어 있다고 가정하여, 1부터 length-1까지 반복한다.
        for (int i=1; i<arr.length; i++) {
            // arr[i]가 새로 추가된 값이다.
            int inserted = arr[i];
            // 새로운 값이 저장될 위치를 i-1부터 찾아본다.
            int pos = i-1;
            while (pos >= 0) {
                // 새로운 값이 더 크다면, 반복을 탈출한다.
                if (inserted >= arr[pos]) break;
                // 새로운 값이 더 작으면, 왼쪽 값을 shift한다.
                arr[pos+1] = arr[pos];
                pos--;
            }
            // 새로운 값을 pos+1 인덱스에 저장한다.
            arr[pos+1] = inserted;
            // 중간 과정을 출력한다.
            printArray(arr);
        }

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

        insertionSort2(n, arr);

        scanner.close();
    }
}
