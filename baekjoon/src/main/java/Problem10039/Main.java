package Problem10039;

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
        
        int total = 0;
        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
        	int score = Integer.parseInt(st.nextToken());
        	if (score < 40) total += 40;
        	else total += score;
        }
		bw.write(String.valueOf(total/5));
		bw.flush();
	}
}
