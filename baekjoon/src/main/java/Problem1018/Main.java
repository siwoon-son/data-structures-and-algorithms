package Problem1018;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	// 검은색이 시작인 경우
	private final static char[][] BLACK_FIRST = new char[][]{
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}
	};
	// 흰색이 시작인 경우
	private final static char[][] WHITE_FIRST = new char[][]{
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
			{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
			{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}
	};

	public static void main(String[] args) throws IOException {
		// 체스판 다시 칠하기
		// 무작위로 검은색과 흰색이 칠해진 N*M 보드에서 일부를 잘라
		// 검은색과 흰색이 번갈아 칠해진 8*8 체스판을 만드려한다.
		// 검은색을 흰색으로 또는 흰색을 검은색으로 다시 칠해야 하는 타일의 최소 개수를 구하자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// N*M 보드를 입력받는다.
		char[][] board = new char[N][M];
		for (int i=0; i<N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		// 다시 칠할 타일 최소수를 min에 저장한다.
		int min = Integer.MAX_VALUE;
		// 보드의 좌상점부터 한칸씩 이동하며 최소수를 계산한다.
		// 체스판이 8*8이므로 N-8, M-8까지 반복한다.
		for (int r=0; r<=N-8; r++) {
			for (int c=0; c<=M-8; c++) {
				min = Math.min(min, nOfTilesToChange(board, r, c));
			}
		}

        bw.write(String.valueOf(min));
		bw.flush();
	}

	private static int nOfTilesToChange (char[][] board, int top, int left) {
		// 보드의 (top, left)를 기준으로 바꿔야할 타일 수를 계산한다.
		int countBlack = 0;
		int countWhite = 0;

		for (int r=top; r<top+8; r++) {
			for (int c=left; c<left+8; c++) {
				// 검은색이 시작인 경우의 체스판으로 만들기 위한 바꿔야할 타일의 최소 개수를 누적한다.
				if (board[r][c] != BLACK_FIRST[r-top][c-left]) countBlack++;
				// 흰색이 시작인 경우의 체스판으로 만들기 위한 바꿔야할 타일의 최소 개수를 누적한다.
				if (board[r][c] != WHITE_FIRST[r-top][c-left]) countWhite++;
			}
		}

		// 바꿔야할 최소 타일 수를 반환한다.
		return Math.min(countBlack, countWhite);
	}
}
