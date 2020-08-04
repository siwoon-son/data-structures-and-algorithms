package hackerrank.algorithms.medium.TheGridSearch;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridSearch function below.
    static String gridSearch(String[] G, String[] P) {
        // 2차원 문자열 G에서 패턴 P가 있는지 검사한다.
        final String yes = "YES", no = "NO";
        // G는 RxC, P는 rxc
        int R = G.length;
        int C = G[0].length();
        int r = P.length;
        int c = P[0].length();

        // 비교 시작 점을 (i, j)로 설정한다.
        for (int i=0; i<R-r+1; i++) {
            for (int j=0; j<C-c+1; j++) {
                // G[i][j]를 기준으로 P와 같다면,
                if (equals(G, i, j, P))
                    // "YES"를 반환한다.
                    return yes;
            }
        }

        return no;
    }

    private static boolean equals(String[] G, int i, int j, String[] P) {
        // G에서 비교할 문자의 인덱스를 초기화한다.
        int rG = i, cG = j;
        // 패턴 P의 인덱스를 반복하며 비교한다.
        for (int rP = 0; rP < P.length; rP++) {
            for (int cP = 0; cP < P[0].length(); cP++) {
                // 비교 중에 다른 문자가 있으면 더 이상 비교하지 않는다.
                if (G[rG].charAt(cG) != P[rP].charAt(cP))
                    return false;
                // G의 열 인덱스를 하나 증가시킨다.
                cG++;
            }
            // 행이 증가하면, G의 열 인덱스를 j로 초기화하고,
            cG = j;
            // 행을 하나 증가시킨다.
            rG = rG + 1;
        }
        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] RC = scanner.nextLine().split(" ");

            int R = Integer.parseInt(RC[0]);

            int C = Integer.parseInt(RC[1]);

            String[] G = new String[R];

            for (int i = 0; i < R; i++) {
                String GItem = scanner.nextLine();
                G[i] = GItem;
            }

            String[] rc = scanner.nextLine().split(" ");

            int r = Integer.parseInt(rc[0]);

            int c = Integer.parseInt(rc[1]);

            String[] P = new String[r];

            for (int i = 0; i < r; i++) {
                String PItem = scanner.nextLine();
                P[i] = PItem;
            }

            String result = gridSearch(G, P);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
