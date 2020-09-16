package Problem1929;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// M부터 N까지의 소수를 모두 출력한다.
		// 에라토스테네스의 체로 풀이한다.
		// 2부터 N까지의 정수 리스트가 있을 때,
		// 2를 제외한 배수, 3을 제외한 배수, 5를 제외한 배수, ... 를 지워나간다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		// 0부터 N까지의 정수 배열을 생성한다.
		boolean[] notPrimes = new boolean[N+1];
		// 0과 1은 소수가 아니므로 제외한다.
		notPrimes[0] = notPrimes[1] = true;

		// 2부터 루트 N까지 배수들을 제외시킨다.
		for (int i=2; i*i<=N; i++) {
			if (notPrimes[i]) continue;
			for (int j=i*i; j<=N; j+=i) {
				notPrimes[j] = true;
			}
		}

		// 출력 메시지를 생성한다.
		StringBuilder sb = new StringBuilder();
		for (int i=M; i<=N; i++) {
			if (notPrimes[i]) continue;
			sb.append(i).append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}
}
