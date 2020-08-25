package hackerrank.datastructures.medium.FindMaximumIndexProduct;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static long solve(int[] arr) {
        // arr[i]보다 크고 가장 가까운 왼쪽 값과 오른쪽 값의 곱을 index product라 한다.
        // 모든 i에 대해 가장 큰 index product를 반환한다.

        int N = arr.length;
        // 모든 원소의 index product를 저장할 두 배열을 생성한다.
        int[] left = new int[N];
        int[] right = new int[N];

        // 왼쪽 index product를 계산한다.
        for (int i=1; i<N; i++) {
            // idxL은 1 to N 인덱스라 i의 왼쪽 원소 인덱스를 i라 한다.
            int idxL = i;
            // arr[i]보다 크고 가장 가까운 왼쪽 인덱스를 찾는다.
            while (idxL > 0 && arr[i] >= arr[idxL-1]) {
                idxL = left[idxL-1];
            }
            left[i] = idxL;
        }

        // 오른쪽 index product를 계산한다.
        for (int i=N-2; i>=0; i--) {
            // idxR은 1 to N 인덱스라 i의 오른쪽 원소 인덱스를 i+2라 한다.
            int idxR = i+2;
            // arr[i]보다 크고 가장 가까운 오른쪽 인덱스를 찾는다.
            while (idxR > 0 && arr[i] >= arr[idxR-1]) {
                idxR = right[idxR-1];
            }
            right[i] = idxR;
        }

        // max index product를 계산한다.
        long maxIdxProduct = 0;
        for (int i=0; i<N; i++) {
            maxIdxProduct = Math.max(maxIdxProduct, (long) left[i] * right[i]);
        }

        return maxIdxProduct;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
