package boj.Problem2447;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		printRect(N);

//		bw.write(String.valueOf(fact(N, 1)));
		bw.flush();
	}
	private static void printRect(int n) {
		if (n == 1) System.out.print("*");

	}
}
