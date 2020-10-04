package Problem11399;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// ATM
		// 1번부터 N번까지 사람들이 ATM을 기다리고 있다.
		// 각 사람들의 인출 시간이 주어질 때,
		// 대기 시간을 포함한 인출 시간의 최소값을 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] Ps = new int[N];
		for (int i=0; i<N; i++) {
			Ps[i] = Integer.parseInt(st.nextToken());
		}

		// 인출 시간을 오름 차순으로 정렬한다.
		Arrays.sort(Ps);

		// 인출 시간이 짧은 순서대로 대기 시간과 인출 시간을 합한다.
		int elapsed = 0;
		int acc = 0;
		for (int i=0; i<N; i++) {
			acc += Ps[i];
			elapsed += acc;
		}

        bw.write(String.valueOf(elapsed));
		bw.flush();
	}

}
