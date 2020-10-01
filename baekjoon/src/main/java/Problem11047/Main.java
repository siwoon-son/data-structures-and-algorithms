package Problem11047;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 동전 0
		// N개의 오름차순으로 주어지는 동전의 가치들로부터 합을 K로 만들기 위한 최소 동전 개수를 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] coins = new int[N];
		for (int i=0; i<N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		// 가장 큰 가치부터 합이 K가 되도록 개수를 센다.
		int count = 0;
		for (int i=N-1; i>=0; i--) {
			if (coins[i] > K) continue;
			else {
				count += K/coins[i];
				K %= coins[i];
			}
		}

        bw.write(String.valueOf(count));
		bw.flush();
	}
}
