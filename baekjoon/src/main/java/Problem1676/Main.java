package Problem1676;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// N!의 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지의 0의 개수
		// 2의 개수와 5의 개수의 최소값을 반환
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int count2 = 0;
		int count5 = 0;
		for (int i=2; i<=N; i++) {
			int tmp = i;
			while (tmp % 2 == 0) {
				count2++;
				tmp /= 2;
			}
			while (tmp % 5 == 0) {
				count5++;
				tmp /= 5;
			}
		}

        bw.write(String.valueOf(Math.min(count2, count5)));
		bw.flush();
	}
}
