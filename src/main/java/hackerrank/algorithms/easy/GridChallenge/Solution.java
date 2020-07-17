package hackerrank.algorithms.easy.GridChallenge;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        // NxN 문자 배열에서 행 단위로 정렬했을때, 열 단위로도 정렬이 되는지 확인한다.
        // 행 단위 정렬을 위해 1차원 문자열배열을 2차원 문자배열로 변환한다.
        final int N = grid.length;
        char[][] charGrid = new char[N][N];
        for (int row=0; row<N; row++) {
            charGrid[row] = grid[row].toCharArray();
        }

        // 첫 번째 행을 정렬하고,
        Arrays.sort(charGrid[0]);
        // 두 번째 행부터 정렬 후에 이전의 행과 비교한다.
        for (int i=1; i<N; i++) {
            Arrays.sort(charGrid[i]);
            // 이전의 행과 현재 행이 열 단위로 정렬되었는지 비교한다.
            for (int j=0; j<N; j++) {
                if (charGrid[i-1][j] > charGrid[i][j])
                    return "NO";
            }
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            System.out.println(result);
        }

        scanner.close();
    }
}
