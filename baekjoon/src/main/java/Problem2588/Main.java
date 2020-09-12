package Problem2588;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
		int first = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int second = Integer.parseInt(st.nextToken());

		int multiplication = first * second;

		while (second > 0) {
			bw.write(String.valueOf(first * (second % 10)));
			bw.newLine();

			second /= 10;
		}
		bw.write(String.valueOf(multiplication));
		bw.newLine();
		
		bw.flush();
	}
}
