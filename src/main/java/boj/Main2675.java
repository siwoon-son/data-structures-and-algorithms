package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2675 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			String newS = "";
			for (int i=0; i<S.length(); i++) {
				for (int j=0; j<R; j++) {
					newS += S.charAt(i);
				}
			}
			bw.write(newS);
			bw.newLine();
		}
		bw.flush();
	}
}
