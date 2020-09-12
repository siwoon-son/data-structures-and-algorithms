package Problem4344;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int sum = 0;
			int[] scores = new int[N]; 
			for (int j=0; j<N; j++) {
				scores[j] = Integer.parseInt(st.nextToken());
				sum += scores[j];
			}
			double average = sum/N;
			int count = 0;
			for (int j=0; j<N; j++) {
				if (scores[j] > average)
					count ++;
			}
			bw.write(String.format("%.3f%%", (double)count/N*100));
			bw.newLine();
		}
		bw.flush();
	}
}
