package hackerrank.algorithms.medium.AlmostSorted;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        // 거의 정렬된 배열을 swap 또는 reverse 연산만으로 정렬할 수 있는지 확인한다.
        // 먼저, 정렬되지 않은 부분의 좌우측 인덱스를 가져온다.
        int l=0, r=arr.length-1;
        while (arr[l] < arr[r]) {
            if (arr[l] < arr[l+1]) l++;
            if (arr[r-1] < arr[r]) r--;
        }
        // 좌측 인덱스가 우측 인덱스보다 크거나 같으면, 이미 정렬된 배열이다.
        if (l >= r) {
            System.out.println("yes");
            return;
        }

        // swap 연산을 시도한다.
        swap(arr, l, r);
        // swap 연산만으로 잘 정렬되었는지 확인한다.
        if (isAscending(arr, l, r) && (l == 0 || arr[l] > arr[l-1]) && (r == arr.length - 1 || arr[r] < arr[r+1])) {
            System.out.println("yes");
            System.out.println("swap " + (l+1) + " " + (r+1));
            return;
        }

        // 다시 swap하여 원상태로 되돌린다.
        swap(arr, l, r);
        // reverse 연산으로 정렬할 수 있는지 확인한다.
        if (isDescending(arr, l, r) && (l == 0 || arr[l] < arr[r+1]) && (r == arr.length - 1 || arr[r] > arr[l-1])) {
            System.out.println("yes");
            System.out.println("reverse " + (l+1) + " " + (r+1));
            return;
        }

        // 여기까지 도달하면 swap과 reverse로 불가능하다.
        System.out.println("no");
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isAscending(int[] arr, int from, int to) {
        for (int i=from; i<to; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    private static boolean isDescending(int[] arr, int from, int to) {
        for (int i=from; i<to; i++) {
            if (arr[i] < arr[i+1])
                return false;
        }
        return true;
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

        almostSorted(arr);

        scanner.close();
    }
}
