package Problem2581;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// 두 숫자 사이의 소수들을 찾아 합과 최소값을 반환하는 프로그램
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int from = Integer.parseInt(br.readLine());
		int to = Integer.parseInt(br.readLine());

        int min = 0;
        int sum = 0;
		for (int i=from; i<=to; i++) {
			if (!isPrimeNumber(i)) continue;
			if (min == 0) min = i;
			sum += i;
		}

		bw.write(min == 0 ? "-1\n" : sum + "\n" + min + "\n");
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