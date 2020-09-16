package Problem1929;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
	public static void main(String[] args) throws IOException {
		// 에라토스테네스의 체와 반대로 2부터 소수들을 찾고,
		// 소수들로 나뉘지 않는 숫자를 소수로 판단하는 코드
		// 결과적으로 에라토스테네스의 체보다 약 1.5배 느리다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		List<Integer> primes = new ArrayList<>();
		for (int i=2; i<=N; i++) {
			boolean isPrime = true;
			for (int p: primes) {
				if (i < p*p) break;
				if (i % p == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) primes.add(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int p: primes) {
			if (p < M) continue;
			sb.append(p).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}

