package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main9498 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(getSecondNumber(A, B, C)));
		bw.flush();
	}
	private static int getSecondNumber(int a, int b, int c) {
		if (a >= b && a >= c) {
			if (b >= c)
				return b;
			else
				return c;
		} else if (b >= a && b >= c) {
			if (a >= c)
				return a;
			else
				return c;
		} else {
			if (a >= b)
				return a;
			else
				return b;
		}
	}
}
