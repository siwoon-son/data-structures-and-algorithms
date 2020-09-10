package boj.Problem1546;

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
		int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int sum = 0;
        for (int i=0; i<N; i++) { 
        	int score = Integer.parseInt(st.nextToken());
        	sum += score;
        	if (max < score)
        		max = score;
        }
        bw.write(String.valueOf((double)sum*100/N/max));
		
		bw.flush();
	}
}
