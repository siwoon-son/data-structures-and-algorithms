package algorithms.medium.FlippingTheMatrix;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flippingMatrix function below.
    static int flippingMatrix(int[][] matrix) {
        // 2N * 2N matrix는 행 또는 열 단위로 reverse할 수 있다.
        // 좌측상단의 N*N matrix 합이 최대가 될 때의 합을 계산하자.

        // 중요. (1, 1)은 (N, 1), (1, N), (N, N)으로만 이동할 수 있다.

        final int N = matrix.length/2;
        final int TWO_N = matrix.length;
        int sum = 0;

        // 좌측상단 N*N 좌표를 순회하며,
        // 각 좌표에 올 수 있는 좌상, 우상, 우하, 좌하점들 중 최대값을 찾는다.
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                int max = 0;
                int r, c;
                // left-top
                r = i;
                c = j;
                max = Math.max(matrix[r][c], max);
                // right-top
                r = i;
                c = TWO_N - j - 1;
                max = Math.max(matrix[r][c], max);
                // right-bottom
                r = TWO_N - i - 1;
                c = TWO_N - j - 1;
                max = Math.max(matrix[r][c], max);
                // left-bottom
                r = TWO_N - i - 1;
                c = j;
                max = Math.max(matrix[r][c], max);

                sum += max;
            }
        }

        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] matrix = new int[2*n][2*n];

            for (int i = 0; i < 2*n; i++) {
                String[] matrixRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2*n; j++) {
                    int matrixItem = Integer.parseInt(matrixRowItems[j]);
                    matrix[i][j] = matrixItem;
                }
            }

            int result = flippingMatrix(matrix);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
