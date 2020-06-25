package hackerrank.algorithms.medium.OrganizingContainersOfBalls;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int n = container.length;
        long[] sumRow = new long[n];
        long[] sumCol = new long[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sumRow[i] += container[i][j];
                sumCol[i] += container[j][i];
            }
        }

        Arrays.sort(sumRow);
        Arrays.sort(sumCol);
        for (int i=0; i<n; i++) {
            if (sumRow[i] != sumCol[i]) return "Impossible";
        }

        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            System.out.println(result);
        }

        scanner.close();
    }
}
