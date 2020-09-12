package Problem10872;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		bw.write(String.valueOf(fact(N, 1)));
		bw.flush();
	}
	private static long fact(int n, long acc) {
		if (n == 0) return acc;
		return fact(n-1, n*acc);
	}
}
