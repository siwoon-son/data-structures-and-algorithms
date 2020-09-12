package algorithms.medium.ClimbingTheLeaderboard;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        // dense ranking는 {1, 2, 2, 3, 4, ...}와 같이,
        // 동일 점수는 같은 순위이며, 이후 순위는 숫자가 끊기지 않고 연속적이다.
        // 기존의 leader board에 점수들이 scores(내림차순)로 기록되었을 때,
        // alice의 점수들(오름차순) 각각의 순위를 반환한다.

        // 기존 scores의 점수에 따른 순위를 Map에 저장한다.
        Map<Integer, Integer> ranking = new HashMap<>();
        int prevScore = -1;
        int prevRank = 1;
        for (int score: scores) {
            if (score == prevScore) continue;
            ranking.put(score, prevRank++);
            prevScore = score;
        }

        // Alice 점수들의 순위를 기록한다.
        int[] results = new int[alice.length];
        for (int i=0, j=scores.length-1; i<alice.length; i++) {
            // 기존에 가장 낮은 점수부터 순서대로 비교한다.
            while (j >= 0 && scores[j] <= alice[i]) {
                j--;
            }

            // 더 높은 점수가 없으면 1등이며,
            // 더 높은 점수가 있으면 해당 순위의 + 1을 저장한다.
            results[i] = j < 0 ? 1 : ranking.get(scores[j]) + 1;
        }

        return results;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
