package Problem15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 1부터 N까지 숫자들로부터 M개의 순열을 오름차순으로 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		permutation(N, M, 0, new boolean[N], "");

        bw.write(sb.toString());
		bw.flush();
	}

	private static void permutation(int N, int M, int nOf, boolean[] visit, String seq) {
		// depth first search로 순열을 기록한다.

		// 순열의 길이가 M개에 도달하면, 출력 메시지를 기록한다.
		if (nOf == M) {
			sb.append(seq.trim()).append("\n");
			return;
		}

		// 1부터 N까지 현재 자리에 올 수 있는 모든 숫자들을 넣으며 다음 자리와 연결한다.
		for (int i=1; i<=N; i++) {
			// 이전에 등장한 수는 현재 자리에 올 수 없다.
			if (visit[i-1]) continue;
			// 현재 자리에 들어간 숫자를 체크한다.
			visit[i-1] = true;
			// 다음 자리에 들어갈 숫자를 탐색한다.
			permutation(N, M, nOf+1, visit, seq + " " + i);
			// 현재 자리에 들어간 숫자를 해제한다.
			visit[i-1] = false;
		}
	}
}
