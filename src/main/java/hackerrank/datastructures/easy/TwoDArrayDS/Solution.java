package hackerrank.datastructures.easy.TwoDArrayDS;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int[][] hourglassCoords = new int[][] {
                {0, 0}, {0, 1}, {0, 2},
                        {1, 1},
                {2, 0}, {2, 1}, {2, 2}
        };

        int maxHourglassSum = Integer.MIN_VALUE;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                int sum = 0;
                for (int[] coord: hourglassCoords) {
                    sum += arr[i+coord[0]][j+coord[1]];
                }
                maxHourglassSum = Math.max(sum, maxHourglassSum);
            }
        }

        return maxHourglassSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
