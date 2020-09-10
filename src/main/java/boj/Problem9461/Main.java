package boj.Problem9461;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        long[] lengths = new long[100+1];
        lengths[1] = 1;
        lengths[2] = 1;
        lengths[3] = 1;
        lengths[4] = 2;
        lengths[5] = 2;
		int last = 6;
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (; last<=n; last++) {
				lengths[last] = lengths[last-5] + lengths[last-1];
			}
			bw.write(String.valueOf(lengths[n]) + "\n");
		}
		bw.flush();
	}
}