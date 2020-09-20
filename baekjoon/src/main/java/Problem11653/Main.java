package Problem11653;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		for (int factor = 2; N > 1; factor++) {
			while (N % factor == 0) {
				sb.append(factor).append("\n");
				N = N / factor;
			}
		}

        bw.write(sb.toString());
		bw.flush();
	}
}
