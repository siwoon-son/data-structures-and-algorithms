package Problem2447;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		// N * N 배열을 생성 후 공백으로 채운다.
		char[][] rect = new char[N][N];
		for (int i=0; i < N; i++) {
			for (int j=0; j < N; j++) {
				rect[i][j] = ' ';
			}
		}

		// 별을 찍는다.
		getStarRectangle(rect, 0, 0, N);

		// N * N 배열을 문자열로 변환한다.
		StringBuilder sb = new StringBuilder();
		for (int i=0; i < N; i++) {
			for (int j=0; j < N; j++) {
				sb.append(rect[i][j]);
			}
			sb.append("\n");
		}

		// 출력한다.
		bw.write(sb.toString());
		bw.flush();
	}

	public static void getStarRectangle(char[][] rect, int r, int c, int n) {
		// 재귀의 끝에서 별을 찍는다.
		if (n == 1) {
			rect[r][c] = '*';
			return;
		}

		// 다음 재귀 호출에서는 N을 3으로 나눈다.
		// 즉, N * N 배열을 아홉 개로 나누고, 각각에서 별을 찍는다.
		int next = n / 3;
		for (int i=0; i < 3; i++) {
			for (int j=0; j < 3; j++) {
				// 가운데 칸은 공백으로 남겨둔다.
				if (i == 1 && j == 1) continue;
				// 아홉 개 각각의 좌상점을 이동하며 재귀 호출한다.
				getStarRectangle(rect, r + (next * i),c + (next * j), next);
			}
		}
	}
}
