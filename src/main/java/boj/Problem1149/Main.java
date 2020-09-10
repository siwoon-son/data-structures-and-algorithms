package boj.Problem1149;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] prices = new int[N+1][3];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			prices[i][0] = Integer.parseInt(st.nextToken());
			prices[i][1] = Integer.parseInt(st.nextToken());
			prices[i][2] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N+1][3];
		dp[1] = prices[1];
		for (int i=2; i<=N; i++) {
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + prices[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + prices[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + prices[i][2];
		}
		int minPrice = Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]);

		bw.write(String.valueOf(minPrice) + "\n");
		bw.flush();
	}
}