package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main6064 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int ith = -1;
			if (M>N)	ith = ithYear(M, N, x, y);
			else		ith = ithYear(N, M, y, x);
			
			bw.write(String.valueOf(ith));
			bw.newLine();
		}
		bw.flush();
	}
	private static int ithYear(int M, int N, int x, int y) {
		int ith = -1;
		for (int candidate=x; candidate<=lcm(M, N); candidate+=M) {
			if ((candidate-1) % N == y-1) {
				ith = candidate;
				break;
			}
		}
		return ith;
	}
	private static int lcm(int a, int b) {
		int gcd = gcd(a, b);
		if (gcd == 0) return 0;

		return Math.abs((a*b)/gcd);
	}
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return Math.abs(a);
	}
}
