package hackerrank.algorithms.medium.ConnectedCellsInAGrid;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static int[][] adjacents = new int[][]{
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1},           {0, 1},
            {1, -1}, {1, 0}, {1, 1}
    };

    // Complete the connectedCell function below.
    static int connectedCell(int[][] matrix) {
        final int nRow = matrix.length;
        final int nCol = matrix[0].length;

        int largest = 0;

        for (int i=0; i<nRow; i++) {
            for (int j=0; j<nCol; j++) {
                int cur = getNOfCellsInRegionAndMarkZero(matrix, i, j);
                largest = Math.max(largest, cur);
            }
        }

        return largest;
    }

    private static int getNOfCellsInRegionAndMarkZero(int[][] matrix, int i, int j) {
        if (matrix[i][j] == 0) return 0;
        final int nRow = matrix.length;
        final int nCol = matrix[0].length;
        int nOfCells = 0;

        Queue<int[]> toBeVisited = new LinkedList<>();
        toBeVisited.add(new int[]{i, j});

        while (!toBeVisited.isEmpty()) {
            int[] cell = toBeVisited.remove();
            if (matrix[cell[0]][cell[1]] == 0) continue;
            matrix[cell[0]][cell[1]] = 0;
            nOfCells++;
            for (int[] adjacent: adjacents) {
                int iToVisit = cell[0]+adjacent[0];
                int jToVisit = cell[1]+adjacent[1];
                if (iToVisit >= nRow || iToVisit < 0 ||
                    jToVisit >= nCol || jToVisit < 0) continue;
                toBeVisited.add(new int[]{iToVisit, jToVisit});
            }
        }

        return nOfCells;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] matrixRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int matrixItem = Integer.parseInt(matrixRowItems[j]);
                matrix[i][j] = matrixItem;
            }
        }

        int result = connectedCell(matrix);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
