package hackerrank.algorithms.medium.CountLuck;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MySolutionFailed {

    private static int[][] LRUD = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    // Complete the countLuck function below.
    static String countLuck(String[] matrix, int k) {
        int nrow = matrix.length;
        int ncol = matrix[0].length();
        char[][] map = new char[nrow][ncol];
        int[] start = new int[2];

        for (int i=0; i<nrow; i++) {
            for (int j = 0; j < ncol; j++) {
                map[i][j] = matrix[i].charAt(j);
                if (map[i][j] == 'M') {
                    start[0] = i; start[1] = j;
                }
            }
        }

        int count = countLuck(map, start);
        return k == count ? "Impressed" : "Oops!";
    }

    private static int countLuck(char[][] map, int[] cur) {
        final int nrow = map.length;
        final int ncol = map[0].length;
        int count = 0;

        Stack<int[]> fork = new Stack<>();
        fork.push(cur);
        while (!fork.isEmpty()) {
            cur = fork.pop();
            int i = cur[0];
            int j = cur[1];
            if (map[i][j] == '*') break;
            map[i][j] = 'X';
            printMap(map);

            int nOfDirection = 0;
            for (int[] direction: LRUD) {
                int directionI = i + direction[0];
                int directionJ = j + direction[1];
                if (directionI >= nrow || directionI < 0 || directionJ >= ncol || directionJ < 0) continue;
                if (map[directionI][directionJ] == 'X') continue;
                fork.push(new int[]{directionI, directionJ});
                nOfDirection++;
            }

            if (nOfDirection > 1) count ++;
        }

        return count;
    }

    private static void printMap (char[][] map) {
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            String[] matrix = new String[n];

            for (int i = 0; i < n; i++) {
                String matrixItem = scanner.nextLine();
                matrix[i] = matrixItem;
            }

            int k = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = countLuck(matrix, k);

            System.out.println(result);
        }

        scanner.close();
    }
}
