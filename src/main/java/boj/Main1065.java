package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for (int i=1; i<=N; i++) {
			if (isHansu(i))	{
				count++;
			}
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static boolean isHansu(int n) {
		int d = (n % 10) - (n / 10 % 10);
		do {
			if ((n % 10) - (n / 10 % 10) != d) return false;
			n /= 10;
		} while (n >= 10);
		return true;
	}
}
