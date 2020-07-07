package hackerrank.algorithms.easy.IntroToTutorialChallenges;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the introTutorial function below.
    static int introTutorial(int V, int[] arr) {
        // 정렬된 arr에서 V의 인덱스를 반환한다.
        // 가장 간단한 binary search를 사용한다.

        // 왼쪽 인덱스 l을 0으로, 오른쪽 인덱스 r을 arr의 길이로 초기화한다.
        int l = 0;
        int r = arr.length;
        // l이 r보다 작다면 반복한다.
        while (l < r) {
            // 중간 인덱스 mid를 계산한다.
            int mid = (l + r) / 2;
            // 정답을 찾았다면 해당 인덱스를 반환한다.
            if (V == arr[mid]) return mid;
            // 찾는 값이 더 크면, 왼쪽 인덱스를 중간 인덱스 + 1로 변환한다.
            if (V > arr[mid]) l = mid+1;
            // 찾는 값이 더 작으면, 오른쪽 인덱스를 중간 인덱스로 변환한다.
            else r = mid;
        }
        // 값을 못 찾았을 경우 -1001을 반환한다.
        // 이는 V의 범위를 벗어난 값으로,
        // 문제에서 V가 정확히 한번은 arr에 속하기 때문에 unreachable 영역이다.
        return -1001;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int V = scanner.nextInt();
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

        int result = introTutorial(V, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
