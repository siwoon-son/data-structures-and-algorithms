package Problem3036;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 첫 번째링이 한 바퀴 도는 동안, 나머지 링이 얼마나 도는지 기약분수로 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] rings = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			rings[i] = Integer.parseInt(st.nextToken());
		}

		StringBuilder sb = new StringBuilder();
		for (int i=1; i<N; i++) {
			sb.append(getIrreducibleFraction(rings[0], rings[i])).append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}

	private static String getIrreducibleFraction (int a, int b) {
		// b부터 1까지 a와 b로 나누며 약분한다.
		int tmp = b;
		while (tmp > 1) {
			if (a % tmp == 0 && b % tmp == 0) {
				a /= tmp;
				b /= tmp;
				tmp = b;
			} else {
				tmp --;
			}
		}

		return a + "/" + b;
	}
}
