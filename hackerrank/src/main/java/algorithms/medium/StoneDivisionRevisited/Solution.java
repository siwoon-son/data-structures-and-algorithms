package algorithms.medium.StoneDivisionRevisited;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the stoneDivision function below.
    static long stoneDivision(long n, long[] s) {
        // n 개의 돌들을 move하여 여러 pile을 만드려 한다.
        // move는 다음과 같이 동작할 수 있다.
        // (1) 여러 pile 중 하나의 pile을 선택했을 때 해당 pile에 있는 돌의 수를 y라 한다.
        // (2) 배열 s 중에서 y와 같지 않으며 y를 나누어떨어트리는 x가 있으면, 해당 pile은 y/x 개의 pile들로 나눌 수 있다.
        // 이때, 최대 가능한 move 수를 반환한다.

        // 특정 수의 돌을 갖는 pile의 최대 가능한 move 수를 memoization한다.
        return stoneDivision(n, s, new HashMap<Long, Long>());
    }
    private static long stoneDivision(long n, long[] s, Map<Long, Long> memo) {
        // n 값이 1 또는 0이면 더이상 move할 수 없으므로 0을 반환한다.
        if (n == 1 || n == 0)   return 0;
        // 기존에 계산한적이 있는 pile은 memo에서 그 수를 반환한다.
        if (memo.containsKey(n))    return memo.get(n);

        // 최대 move 수를 0으로 초기화한다.
        long max = 0;
        for (long sizeOfPile: s) {
            // (2)를 만족하지 않으면 넘어간다.
            if (!(sizeOfPile != n && n % sizeOfPile == 0)) continue;
            // pile 들의 수를 계산한다.
            long nOfPiles = n / sizeOfPile;
            // move를 하므로 1을 추가하고,
            // 나누어진 파일에 대해 최대 가능한 move 수를 재귀적으로 계산하고 pile 수를 곱한다.
            long nOfMoves = 1 + (stoneDivision(sizeOfPile, s, memo) * nOfPiles);
            // 기존 최대값과 비교하여 대체한다.
            max = Math.max(max, nOfMoves);
        }
        // n개의 돌에 대한 최대 가능한 move 수를 memoization한다.
        memo.put(n, max);

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            long n = Long.parseLong(nm[0]);

            int m = Integer.parseInt(nm[1]);

            long[] s = new long[m];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < m; i++) {
                long sItem = Long.parseLong(sItems[i]);
                s[i] = sItem;
            }

            long result = stoneDivision(n, s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
