package Problem11050;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 이항 계수를 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(binomialCoefficient(n, r)));
		bw.flush();
	}

	private static int binomialCoefficient(int n, int r) {
		return binomialCoefficient(n, r, new int[n+1][n+1]);
	}

	private static int binomialCoefficient(int n, int r, int[][] memo) {
		if (memo[n][r] > 0)
			return memo[n][r];

		if (r == 0 || n == r)
			return memo[n][r] = 1;

		return memo[n][r] = binomialCoefficient(n-1, r-1, memo) + binomialCoefficient(n-1, r, memo);
	}


}
