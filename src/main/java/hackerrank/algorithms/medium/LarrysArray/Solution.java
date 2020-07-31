package hackerrank.algorithms.medium.LarrysArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        // Array A는 1부터 n으로 이루어져 있으며,
        // 연속된 세자리를 다음과 같이 rotate할 수 있다.
        // ABC -> BCA -> CAB -> ABC
        // 주어진 A가 rotate만으로 정렬할 수 있을까?

        // 이 문제를 처음에는 실제로 rotate하는 방법을 구현하였다.
        // 하지만, 다음과 같이 더 효율적인 코드를 찾았다.

        // 다음 코드는 A[i] > A[j] (i<j)를 만족하는 수를 세고,
        // 이 수가 홀수면 불가능하고, 짝수면 가능하다.
        int count = 0;
        for (int i=0; i<A.length-1; i++) {
            for (int j=i+1; j<A.length; j++) {
                if (A[i] > A[j]) count++;
            }
        }

        return (count & 1) == 1 ? "NO" : "YES";

//        // i-번째 가장 큰 숫자를 오른쪽으로 보낸다.
//        for (int i=0; i<A.length-2; i++) {
//            // 가장 큰 숫자를 오른쪽으로 보낸다.
//            for (int j=0; j<A.length-2-i; j++)
//                rotate(A, j);
//        }
//
//        // 처음 세 숫자가 123이면 정답이다.
//        return A[0] == 1 && A[1] == 2 && A[2] == 3 ? "YES" : "NO";
    }

//    private static void rotate(int[] A, int from) {
//        // 세 숫자를 가져온다.
//        int x1 = A[from];
//        int x2 = A[from+1];
//        int x3 = A[from+2];
//
//        // 첫 번째 숫자가 가장 큰 경우
//        if (x1 > x2 && x1 > x3) {
//            A[from] = x2;
//            A[from+1] = x3;
//            A[from+2] = x1;
//        }
//        // 두 번째 숫자가 가장 큰 경우
//        else if (x2 > x1 && x2 > x3) {
//            A[from] = x3;
//            A[from+1] = x1;
//            A[from+2] = x2;
//        }
//    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] A = new int[n];

            String[] AItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int AItem = Integer.parseInt(AItems[i]);
                A[i] = AItem;
            }

            String result = larrysArray(A);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
