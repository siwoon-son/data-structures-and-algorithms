package Problem1978;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// N 개의 숫자들로부터 소수의 개수를 세는 함수
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
        int nOfPrime = 0;
		while (N-- > 0) {
			int i = Integer.parseInt(st.nextToken());
			nOfPrime += isPrimeNumber(i) ? 1 : 0;
		}

		bw.write(nOfPrime + "\n");
		bw.flush();
	}

	// 주어진 숫자가 소수인지 판별하는 함수
	private static boolean isPrimeNumber (int n) {
		if (n == 1) return false;

		for (int i=2; i<=n/2; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}