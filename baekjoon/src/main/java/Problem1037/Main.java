package Problem1037;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 어떤 숫자의 진짜 약수는 1과 N을 제외한 약수이다.
		// 주어진 진짜 약수들로부터 해당 숫자를 찾아내자.

		// 이는 최소값 * 최대값이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = Math.min(num, min);
			max = Math.max(num, max);
		}

        bw.write(String.valueOf(min*max));
		bw.flush();
	}
}
