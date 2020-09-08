package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2908 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        A = reverse(A);
        B = reverse(B);
        
        bw.write(String.valueOf(max(A, B)));
		bw.flush();
	}
	private static int reverse(int n) {
		int ret = 0, digit = 10;
		while (n > 0) {
			ret = (ret*digit) + (n % 10);
			n /= 10;
		}
		return ret;
	}
	private static int max(int a, int b) {
		return a > b ? a : b;
	}
}
