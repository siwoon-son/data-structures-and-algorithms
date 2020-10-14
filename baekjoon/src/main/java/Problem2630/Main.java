package Problem2630;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static int nOfWhite = 0;
	private static int nOfBlue = 0;

	public static void main(String[] args) throws IOException {
		// 색종이 만들기
		// N*N 정사각형 색종이가 칸칸이 파란색과 하얀색으로 칠해져있다.
		// 전체 종이가 같은 색이 아니라면 N/2*N/2로 네 개의 색종이로 자르고,
		// 전체 종이가 같은 색이면 그대로 둔다.
		// 주어진 색종이로부터 하얀색과 파란색의 수를 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		// 흰색 칸은 true, 파란색 칸은 false로 저장한다.
		boolean[][] paper = new boolean[N][N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				paper[i][j] = st.nextToken().equals("0");
			}
		}

		// (0, 0) 기준 N*N 칸의 색종이를 한장으로 시작한다.
		divide(paper, 0, 0, N);

        bw.write(nOfWhite + "\n" + nOfBlue);
		bw.flush();
	}

	private static void divide(boolean[][] paper, int r, int c, int n) {
		// 좌상점의 색을 가져온다.
		boolean isLeftTopWhite = paper[r][c];

		// 좌상점부터 n개의 색종이가 같은지 확인한다.
		for (int i=r; i<r+n; i++) {
			for (int j=c; j<c+n; j++) {
				// 색이 다른 종이가 발견되면,
				if (paper[i][j] != isLeftTopWhite) {
					// 색종이를 네 개의 N/2*N/2로 재귀적으로 나눈다.
					int halfN = n/2;
					divide(paper, r, c, halfN);
					divide(paper, r+halfN, c, halfN);
					divide(paper, r, c+halfN, halfN);
					divide(paper, r+halfN, c+halfN, halfN);
					return;
				}
			}
		}

		// n개의 색종이가 모두 같은 색이면,
		// 좌상점의 색에 따라 개수를 증가시킨다.
		// (단, n이 1일때도 포함된다.)
		if (isLeftTopWhite) nOfWhite++;
		else nOfBlue++;
	}
}
