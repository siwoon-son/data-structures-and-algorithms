package hackerrank.algorithms.easy.RunningTimeOfAlgorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the runningTime function below.
    static int runningTime(int[] arr) {
        // 삽입 정렬에서 shift가 발생한 횟수를 반환한다.
        int count = 0;
        for (int i=1; i<arr.length; i++) {
            int inserted = arr[i];
            int pos = i-1;
            while (pos >= 0) {
                if (inserted >= arr[pos]) break;
                arr[pos+1] = arr[pos];
                pos--;
                // shift가 발생했으니 횟수를 증가시킨다.
                count++;
            }
            arr[pos+1] = inserted;
        }

        return count;
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

        int result = runningTime(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
