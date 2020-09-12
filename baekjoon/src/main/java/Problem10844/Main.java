package Problem10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        long[][] memo = new long[N+1][10];
		memo[1] = new long[]{0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		if (N >= 2)
			memo[2] = new long[]{0, 2, 2, 2, 2, 2, 2, 2, 2, 1};
		for (int i=3; i<=N; i++) {
			memo[i][1] = (memo[i-2][1] + memo[i-1][2]) % 1000000000;
			for (int j=2; j<=8; j++)
				memo[i][j] = (memo[i-1][j-1] + memo[i-1][j+1]) % 1000000000;
			memo[i][9] = memo[i-1][8] % 1000000000;
		}

		long sum = 0;
		for (int i=1; i<=9; i++)
			sum += memo[N][i];
		System.out.println(sum % 1000000000);
	}
}