package Problem2164;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// 1부터 N까지 숫자 카드가 순서대로 주어지고,
		// (1) 가장 윗 카드를 버리고, (2) 다음 윗 카드를 맨 뒤로 보내는 작업을 반복했을 때,
		// 가장 마지막에 남는 카드는 무엇인가?

		// 하나씩 확인해보면 N이 1일때부터 차례대로 마지막에 남는 카드는,
		// 1,
		// 2,
		// 2, 4,
		// 2, 4, 6, 8,
		// 2, 4, 6, 8, 10, 12, 14, 16,
		// 17, ...
		// 이 된다.
		// 따라서, N이 1일때를 제외하면, 1개, 2개, 4개, 8개, 16개, ... 로 반복된다.
		// 이러한 반복 구조로부터 N에 대한 마지막 카드를 찾을 수 있다.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		// N이 1인 경우,
		int last = 1;
		// N이 1보다 큰 경우,
		if (N > 1) {
			// N이 포함되는 구간의 첫 번째 위치를 찾는다.
			int first = (int) Math.pow(2, (int) (Math.log(N-1) / Math.log(2))) + 1;
			// N과 첫 번째 위치로 마지막 카드를 계산한다.
			last = (N - first)*2 + 2;
		}

        bw.write(String.valueOf(last));
		bw.flush();
	}
}
