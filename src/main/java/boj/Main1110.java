package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int departure = Integer.parseInt(st.nextToken());
			int arrival = Integer.parseInt(st.nextToken());
			
			bw.write(String.valueOf(countMinimalMove(departure, arrival, 1)));
			bw.newLine();
		}
		bw.flush();
	}
	private static int countMinimalMove (int d, int a, int interval) {
		if ((a-d) > interval*2) {
			return 2+countMinimalMove(d+interval, a-interval, interval+1);
		} else if ((a-d) > interval) {
			return 2;
		} else {
			return 1;
		}
	}
}
