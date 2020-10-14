package Problem1992;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 쿼드트리
		// 0과 1로 구성된 흑백 영상에서 (왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래) 4개의 값이 모두 같으면 해당 값으로 압축할 수 있다.
		// 만약 값이 서로 다르면 압축할 수 없으므로 순서대로 괄호 안에 묶어서 표현한다.
		// N*N 크기의 영상을 압축하자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// N*N 영상을 2차원 배열에 저장한다.
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		char[][] image = new char[N][N];
		for (int i = 0; i < N; i++) {
			image[i] = br.readLine().toCharArray();
		}

		// 압축한 결과를 출력한다.
		String encoded = encode(image, 0, 0, N);
		bw.write(encoded);
		bw.flush();
	}

	private static String encode(char[][] image, int r, int c, int n) {
		// (r, c) 좌표를 기준으로 n 길이의 정사각형을 압축한다.
		// 길이가 1이면, 즉 값이 하나면
		if (n == 1) {
			// 해당 값을 문자열로 반환한다.
			return String.valueOf(image[r][c]);
		}

		// 정사각형을 4개로 나누어 재귀적으로 압축하고 결과를 각각 저장한다.
		int halfN = n / 2;
		String leftTop = encode(image, r, c, halfN);
		String rightTop = encode(image, r, c+halfN, halfN);
		String leftBottom = encode(image, r+halfN, c, halfN);
		String rightBottom = encode(image, r+halfN, c+halfN, halfN);

		// 4개 모두 압축된 결과이고 모두 같은 값이면,
		if (leftTop.length() == 1 && rightTop.length() == 1 && leftBottom.length() == 1 && rightBottom.length() == 1) {
			if (leftTop.equals(rightTop) && leftTop.equals(leftBottom) && leftTop.equals(rightBottom))
				// 하나의 값으로 다시 압축하여 반환한다.
				return leftTop;
		}

		// 압축할 수 없으므로 괄호로 묶는다.
		return "(" + leftTop + rightTop + leftBottom + rightBottom + ")";
	}
}