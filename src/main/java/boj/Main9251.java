package boj;

import java.io.*;

public class Main9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		int N1 = s1.length();
		int N2 = s2.length();

        int[][] dp = new int[N2+1][N1+1];
        for (int i=1; i<=N2; i++) {
        	for (int j=1; j<=N1; j++) {
        		if (s1.charAt(j-1) == s2.charAt(i-1))
        			dp[i][j] = dp[i-1][j-1] + 1;
        		else
        			dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}

		System.out.println(dp[N2][N1]);
	}
}