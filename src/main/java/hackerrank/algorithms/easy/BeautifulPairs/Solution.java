package hackerrank.algorithms.easy.BeautifulPairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulPairs function below.
    static int beautifulPairs(int[] A, int[] B) {
        int[] bucket = new int[1001];
        for (int a: A) {
            bucket[a]++;
        }

        int nOfPairs = 0;
        for (int b: B) {
            if (bucket[b] > 0) {
                bucket[b]--;
                nOfPairs++;
            }
        }

        return nOfPairs == B.length ? nOfPairs - 1 : nOfPairs + 1;

//        Arrays.sort(A);
//        Arrays.sort(B);
//        int indexA = 0;
//        int indexB = 0;
//
//        int len = 0;
//        while (indexA < A.length && indexB < B.length) {
//            if (A[indexA] == B[indexB]) {
//                indexA++;
//                indexB++;
//                len++;
//            }
//            else if (A[indexA] > B[indexB]) indexB++;
//            else indexA++;
//        }
//
//        return B.length == len ? len - 1 : len + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

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

        int result = beautifulPairs(A, B);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
