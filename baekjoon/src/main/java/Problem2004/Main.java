package Problem2004;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// nCm에서 뒷자리 0의 개수를 센다.
		// n!/(n-m)!m!이므로 각 팩토리얼에 포함되는 2와 5의 개수를 세어 최소값을 반환한다.
		// 값이 매우 크니 long 타입을 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long count2 = countK(n, 2) - countK(n-m, 2) - countK(m, 2);
		long count5 = countK(n, 5) - countK(n-m, 5) - countK(m, 5);

		bw.write(String.valueOf(Math.min(count2, count5)));
		bw.flush();
	}

	private static long countK(long n, int k) {
		long count = 0;
		for (long i=k; i<=n; i*=k) {
			count += n / i;
		}
		return count;
	}
}
