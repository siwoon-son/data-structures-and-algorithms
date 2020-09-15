package Problem10996;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder oddLine = new StringBuilder();
		StringBuilder evenLine = new StringBuilder();

		// 홀수 라인
		oddLine.append("*");
		for (int i=3; i<=N; i+=2) {
			oddLine.append(" *");
		}
		// 짝수 라인
		for (int i=2; i<=N; i+=2) {
			evenLine.append(" *");
		}
		// 한 세트로 연결
		oddLine.append("\n").append(evenLine);

		// 세트를 N개만큼 복제
		StringBuilder concat = new StringBuilder();
		for (int i=1; i<=N; i++) {
			concat.append(oddLine).append("\n");
		}

		bw.write(concat.toString());
		bw.flush();
	}
}
