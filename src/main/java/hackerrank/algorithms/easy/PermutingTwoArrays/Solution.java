package hackerrank.algorithms.easy.PermutingTwoArrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoArrays function below.
    static String twoArrays(int k, int[] A, int[] B) {
        // 배열 A와 B의 원소 합이 k보다 크거나 같을 수 있도록,
        // 두 배열을 재배치할 수 있는지 확인한다.

        // A와 B를 오름차순으로 정렬한다.
        // (B는 내림차순으로 정렬하면 더 편하지만, primitive type이므로 내림차순은 어렵다.)
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i=0; i<A.length; i++) {
            // A의 작은 값과 B의 큰 값부터 두 수의 합이 k보다 작으면,
            if(A[i] + B[A.length-i-1] < k)
                // "NO"를 반환한다.
                return "NO";
        }

        // 모든 비교가 끝나면 "YES"를 반환한다.
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            int[] B = new int[n];

            String[] BItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }

            String result = twoArrays(k, A, B);

            System.out.println(result);
        }

        scanner.close();
    }
}
