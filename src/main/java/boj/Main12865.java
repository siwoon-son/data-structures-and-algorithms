package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N+1][K+1];
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j=1; j<=K; j++) {
                dp[i][j] = dp[i-1][j];
                if (j >= w)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
            }
        }

        int max = dp[N][1];
        for (int j=2; j<=K; j++) {
            max = Math.max(max, dp[N][j]);
        }
        System.out.println(max);
    }
}