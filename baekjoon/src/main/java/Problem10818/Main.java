package Problem10818;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n < min) min = n;
			if (n > max) max = n;
		}

		bw.write(min + " " + max);
		bw.flush();
	}
}
