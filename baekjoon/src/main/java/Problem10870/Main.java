package Problem10870;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(fibo(N, 1, 0)));
		bw.flush();
	}
	private static int fibo(int n, int i, int j) {
		if (n == 0) return j;
		return fibo(n-1, j, i+j);
	}
}
