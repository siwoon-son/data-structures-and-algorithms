package hackerrank.algorithms.easy.BreakingTheRecords;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        // 시즌 동안 최고점과 최저점을 갱신한 횟수를 계산한다.
        // 먼저, 첫 번째 경기의 점수를 최고점/최저점으로 기록한다.
        int best = scores[0];
        int worst = scores[0];
        // 최고점과 최저점을 갱신한 횟수를 기록하는 변수를 0으로 초기화한다.
        int countBreakingBest = 0;
        int countBreakingWorst = 0;

        // 두 번째 경기부터 마지막 경기까지 반복한다.
        for (int i=1; i<scores.length; i++) {
            // 이번 경기가 최고점이면,
            if (scores[i] > best) {
                // 최고점을 갱신하고
                best = scores[i];
                // 횟수를 증가시킨다.
                countBreakingBest++;
            }
            // 이번 경기가 최저점이면,
            else if (scores[i] < worst) {
                // 최저점을 갱신하고
                worst = scores[i];
                // 횟수를 증가시킨다.
                countBreakingWorst++;
            }
        }

        // 최고점과 최저점을 배열로 묶어 반환한다.
        return new int[]{countBreakingBest, countBreakingWorst};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
