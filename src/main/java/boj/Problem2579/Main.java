package boj.Problem2579;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] scores = new int[N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			scores[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N+1];
		dp[1] = scores[1];
		if (N >= 2)
			dp[2] = scores[1] + scores[2];
		for (int i=3; i<=N; i++) {
			dp[i] = Math.max(dp[i-3] + scores[i-1] + scores[i], dp[i-2] + scores[i]);
		}

		System.out.println(dp[N]);
	}
}