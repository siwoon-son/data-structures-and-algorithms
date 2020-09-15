package Problem2562;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int nth = 0;
		int max = 0;
		for (int i=1; i<=9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if (max < n) {
				nth = i;
				max = n;
			}
		}

		bw.write(max + "\n" + nth);
		bw.flush();
	}
}
