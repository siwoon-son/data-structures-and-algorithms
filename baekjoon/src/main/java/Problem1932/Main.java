package Problem1932;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // input data
		int[][] top = new int[T][];
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int[] floor = new int[i+1];
			for (int j=0; j<i+1; j++) {
				int v = Integer.parseInt(st.nextToken());
				floor[j] = v;
			}
			top[i] = floor;
		}

		// calculate
		for (int i=1; i<T; i++) {
			top[i][0] += top[i-1][0];
			top[i][i] += top[i-1][i-1];
			for (int j=1; j<i; j++) {
				top[i][j] += Math.max(top[i-1][j-1], top[i-1][j]);
			}
		}


		// print
		int max = 0;
		for (int v: top[T-1])
			if (v > max) max = v;

		bw.write(max + "\n");
		bw.flush();
	}
}