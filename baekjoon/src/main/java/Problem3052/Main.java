package Problem3052;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 발견된 42의 나머지는 true로 변환
		boolean[] remainder = new boolean[42];
		// 중복되지 않은 나머지의 수를 기록
		int count = 0;
		for (int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			int r = n % 42;
			if (!remainder[r]) {
				remainder[r] = true;
				count++;
			}
		}

		bw.write(String.valueOf(count));
		bw.flush();
	}
}
