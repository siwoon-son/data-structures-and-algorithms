package Problem9020;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 2보다 큰 짝수 n이 주어졌을 때, n은 반드시 두 소수의 합으로 계산될 수 있다.
		// 이를 골드바흐 수라고 한다.
		// 두 소수의 차이가 가장 작은 골드바흐 수를 계산한다.
		// 모든 테스트케이스 중에서 가장 큰 값까지 소수들을 찾고,

		// 테스트케이스의 절반값부터 값을 하나씩 증감시키며 골드바흐 수를 찾는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트케이스들과 가장 큰 값을 찾는다.
        StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] numbers = new int[T];
		int max = 0;
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			numbers[i] = n;
			max = Math.max(max, n);
		}

		// 2*max까지의 소수들을 찾는다.
		boolean[] notPrimes = new boolean[2*max+1];
		notPrimes[0] = notPrimes[1] = true;

		for (int i=2; i*i<=max; i++) {
			if (notPrimes[i]) continue;
			for (int j=i*i; j<=max; j+=i) {
				notPrimes[j] = true;
			}
		}

		// 출력 메시지를 기록한다.
		StringBuilder sb = new StringBuilder();
		for (int n: numbers) {
			// 테스트케이스의 절반값을 l과 r로 초기화한다.
			int l = n/2, r = n/2;
			// 소수가 아니면 l은 감소시키고, r은 증가시킨다.
			while (notPrimes[l] || notPrimes[r]) {
				l--; r++;
			}
			// l과 r이 모두 소수이면, 출력 메시지에 저장한다.
			sb.append(l + " " + r).append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}
}
