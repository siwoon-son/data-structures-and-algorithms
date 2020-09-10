package boj.Problem2920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		int first = Integer.parseInt(st.nextToken());
		int i;
		if (first == 1) {
			for (i=2; i<=8; i++) {
				if (i != Integer.parseInt(st.nextToken())) {
					bw.write("mixed");
					break;
				}
			}
			if (i == 9) bw.write("ascending");
		} else if (first == 8) {
			for (i=7; i>=2; i--) {
				if (i != Integer.parseInt(st.nextToken())) {
					bw.write("mixed");
					break;
				}
			}
			if (i == 1) bw.write("descending");			
		} else {
			bw.write("mixed");
		}
		
		bw.flush();
	}
}
