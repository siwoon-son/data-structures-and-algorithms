package Problem11866;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 요세푸스 문제 0
		// 1번부터 N명의 사람이 원을 이루고, 주어진 양의 정수 K(<=N)이 주어진다.
		// 순서대로 K번째 사람을 제거할때, 제거되는 순서를 (N, K)-요세푸스 수열이라 한다.
		// N, K가 주어지면 수열을 계산하자.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		// 제거 여부를 저장할 배열을 생성한다.
		boolean[] isPicked = new boolean[N];
		// 0부터 N-1까지 반복한다.
		// p는 제거될 위치를 의미한다.
		for (int i=0, p=-1; i<N; i++) {
			// k를 감소시키며 제거될 위치를 찾아나간다.
			int k = K;
			while (k > 0) {
				// p를 하나씩 이동시킨다.
				p = (p+1) % N;
				// 제거되지 않았었다면 k를 감소시킨다.
				if (!isPicked[p]) --k;
			}
			// 제거 후 배열을 true로 변환한다.
			sb.append(p+1).append(", ");
			isPicked[p] = true;
		}

        bw.write("<" + sb.substring(0, sb.length()-2) + ">");
		bw.flush();
	}
}
