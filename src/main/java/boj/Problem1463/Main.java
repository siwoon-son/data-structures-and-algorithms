package boj.Problem1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        int[] memo = new int[N+1];
        memo[1] = 0;
		for (int i=2; i<=N; i++) {
			memo[i] = memo[i-1];
			if (i % 2 == 0) memo[i] = Math.min(memo[i], memo[i/2]);
			if (i % 3 == 0) memo[i] = Math.min(memo[i], memo[i/3]);
			memo[i]++;
		}
		System.out.println(memo[N]);
	}
}