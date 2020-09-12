package Problem2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[][] lines = new int[N+1][2];
        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int[] dp = new int[N+1];
        dp[1] = 1;
        for (int i=2; i<=N; i++) {
            dp[i] = 1;
            for (int j=1; j<i; j++) {
                if (lines[i][1] > lines[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int maxLen = 0;
        for (int i=1; i<=N; i++) {
            maxLen = Math.max(maxLen, dp[i]);
        }

        System.out.println(N-maxLen);
    }
}