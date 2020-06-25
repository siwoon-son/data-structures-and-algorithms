package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		float[] numbers = new float[9]; // 9 to 6
		do {
			int last = N % 10;
			if (last == 6 || last == 9)
				numbers[6] += 0.5;
			else
				numbers[last] += 1;
			N /= 10;
		} while (N > 0);
		double max = 0;
		for (int i=0; i<9; i++) {
			if (numbers[i] > max)
				max = numbers[i];
		}

		bw.write(String.valueOf((int)Math.ceil(max)));
		bw.flush();
	}
}
