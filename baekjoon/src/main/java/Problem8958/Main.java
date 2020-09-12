package Problem8958;

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
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		while (T-- > 0) {
	        st = new StringTokenizer(br.readLine());
			String quiz = st.nextToken();
			int total = 0;
			int score = 0;
			for (int i=0; i<quiz.length(); i++) {
				if (quiz.charAt(i) == 'X')	score = 0;
				else {
					total += ++score;
				}
			}
			bw.write(String.valueOf(total));
			bw.newLine();
		}
		
		bw.flush();
	}
}
