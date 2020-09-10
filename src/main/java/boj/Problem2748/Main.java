package boj.Problem2748;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // fibonacci
		long a = 0, b = 1;
		long ret = 1;
		for (int i = 2; i <= n; i++) {
			ret = a + b;
			a = b;
			b = ret;
		}

		// print
		bw.write(ret + "\n");
		bw.flush();
	}
}