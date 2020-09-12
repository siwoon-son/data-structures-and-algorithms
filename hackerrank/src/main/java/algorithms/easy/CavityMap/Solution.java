package algorithms.easy.CavityMap;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the cavityMap function below.
    static String[] cavityMap(String[] grid) {
        // 상하좌우의 숫자가 현재 숫자보다 모두 작다면 해당 숫자는 cavity이다.
        // 모든 cavity를 'X'로 대체한다.
        // 행과 열의 수를 N으로 저장한다.
        int N = grid.length;
        // 반활할 caivty map을 생성한다.
        String[] cavityMap = new String[N];

        // cavity map의 첫 행은 cavity가 없다.
        cavityMap[0] = grid[0];
        // 첫 행과 마지막 행은 제외한다.
        for (int i=1; i<N-1; i++) {
            // 각 행의 문자들을 append할 string builder를 생성한다.
            StringBuilder line = new StringBuilder();
            // 첫 열은 그대로 저장한다.
            line.append(grid[i].charAt(0));
            // 첫 열과 마지막 열은 제외한다.
            for (int j=1; j<N-1; j++) {
                // 현재 문자와 상하좌우 문자를 가져온다.
                char cur = grid[i].charAt(j);
                char u   = grid[i-1].charAt(j);
                char r   = grid[i].charAt(j+1);
                char d   = grid[i+1].charAt(j);
                char l   = grid[i].charAt(j-1);
                // 상 또는 좌의 문자가 X가 아니고,
                // 상하좌우 문자보다 현재 문자가 크면,
                if ((u != 'X' && cur > u) &&
                    (l != 'X' && cur > l) &&
                    (cur > r) &&
                    (cur > d))
                    // 해당 문자를 'X'로 대체한다.
                    cur = 'X';

                // 현재 문자를 string builder에 추가한다.
                line.append(cur);
            }
            // 마지막 열을 string builder에 추가한다.
            line.append(grid[i].charAt(N-1));
            // 행을 cavity map에 추가한다.
            cavityMap[i] = line.toString();
        }
        // 마지막 행을 cavity map에 추가한다.
        cavityMap[N-1] = grid[N-1];

        return cavityMap;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = cavityMap(grid);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
