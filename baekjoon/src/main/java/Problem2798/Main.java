package Problem2798;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// N개의 카드 중, 세 장의 합이 M에 가장 가까운 합을 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i=0; i<N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		int closest = 0;
		for (int i=0; i<N-2; i++) {
			for (int j=i+1; j<N-1; j++) {
				for (int k=j+1; k<N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if (sum <= M && closest < sum)
						closest = sum;
				}
			}
		}

        bw.write(String.valueOf(closest));
		bw.flush();
	}
}
