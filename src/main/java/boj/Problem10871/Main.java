package boj.Problem10871;

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
		int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) { 
        	int value = Integer.parseInt(st.nextToken());
        	if (value < X)
        		bw.write(String.valueOf(value) + " ");
        }
		
		bw.flush();
	}
}
