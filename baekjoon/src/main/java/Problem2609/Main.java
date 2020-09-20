package Problem2609;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 두 수의 최대공약수와 최소공배수
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = gcd(a, b);
		int lcm = lcm(a, b, gcd);

        bw.write(gcd + "\n" + lcm);
		bw.flush();
	}

	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a%b);
	}

	private static int lcm(int a, int b, int gcd) {
		return (a * b) / gcd;
	}
}
