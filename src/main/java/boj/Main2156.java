package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] wine = new int[N+1];
        for (int i=1; i<=N; i++) {
        	wine[i] = Integer.valueOf(br.readLine());
		}

        int[][] dp = new int[N+1][3];
        dp[1] = new int[]{0, wine[1], wine[1]};
        for (int i=2; i<=N; i++) {
        	dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
        	dp[i][1] = dp[i-1][0] + wine[i];
        	dp[i][2] = dp[i-1][1] + wine[i];
		}

		System.out.println(Math.max(Math.max(dp[N][0], dp[N][1]), dp[N][2]));
	}
}