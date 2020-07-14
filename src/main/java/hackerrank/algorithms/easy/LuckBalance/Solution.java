package hackerrank.algorithms.easy.LuckBalance;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        // row는 i-번째 대회를, 0-column은 해당 대회에 필요한 행운을, 1-column은 대회의 중요도를 의미한다.
        // 중요도는 1(중요함), 0(안중요함)으로 이뤄지며,
        // 대회에서 이기면 행운이 줄고, 지면 행운이 늘어난다.
        // 중요한 대회에서 최대 k번까지 질 수 있을 때, 모든 대회 후에 가질 수 있는 행운의 최대값을 반환한다.

        // 대회 전의 행운을 0으로 초기화한다.
        int maxLucky = 0;

        List<Integer> importantLucky = new ArrayList<>();
        for (int i=0; i<contests.length; i++) {
            // 모든 대회들의 행운을 더한다.
            maxLucky += contests[i][0];
            // 중요 대회들의 행운을 저장한다.
            if (contests[i][1] == 1)
                importantLucky.add(contests[i][0]);
        }

        // 중요 대회 수와 k의 차이만큼은 반드시 이겨야한다.
        for (int i=importantLucky.size(); i>k; i--) {
            // 중요 대회 중에서 가장 적은 행운이 필요한 대회를 찾는다.
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int lucky=0; lucky<importantLucky.size(); lucky++) {
                if (min > importantLucky.get(lucky)) {
                    min = importantLucky.get(lucky);
                    idx = lucky;
                }
            }
            // 가장 적은 행운이 필요한 대회를 제거한다.
            importantLucky.remove(idx);
            // 대회에 참여하므로 더해진 행운과 필요한 행운을 함께 줄인다.
            maxLucky -= min * 2;
        }

        return maxLucky;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
