package hackerrank.algorithms.easy.CutTheSticks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
        // 주어진 sticks에서 가장 짧은 sticks을 버리며 나머지의 개수를 센다.
        // sticks을 길이에 따라 정렬한다.
        Arrays.sort(arr);

        // 결과를 저장할 배열의 길이를 계산한다.
        int nOfStickType = 1;
        for (int i=1; i<arr.length; i++) {
            // 서로 다른 sticks의 수를 센다.
            if (arr[i] != arr[i-1]) nOfStickType++;
        }

        // 결과를 저장할 배열을 생성한다.
        int[] stickCut = new int[nOfStickType];
        // sticks를 순회하며 가장 짧은 sticks을 제외한 나머지의 개수를 저장한다.
        for (int i=0, j=0; i<arr.length; i++) {
            stickCut[j++] = arr.length - i;
            // 연속된 같은 크기의 sticks은 지나간다.
            while (i+1 < arr.length && arr[i] == arr[i+1]) {
                i++;
            }
        }

        return stickCut;
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

        int[] result = cutTheSticks(arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
        scanner.close();
    }
}
