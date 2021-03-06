package Problem15651;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 1부터 N까지 숫자 중에서 M 개의 중복이 허용된 조합을 오름차순으로 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		combination(N, M,0, "");

        bw.write(sb.toString());
		bw.flush();
	}

	private static void combination(int N, int M, int nOf, String seq) {
		// M개에 도달하면 출력 메시지를 기록한다.
		if (nOf == M) {
			sb.append(seq.trim()).append("\n");
			return;
		}

		// 15650 문제와 다르게, 현재 자리에는 1부터 N까지 모두 올 수 있다.
		for (int i=1; i<=N; i++) {
			combination(N, M, nOf+1, seq + " " + i);
		}
	}
}
