package boj.Problem10989;

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
        StringBuffer sb = new StringBuffer();
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] counting = new int[10001];
        while (N-- > 0) {
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            counting[n]++;
        }
        for (int i=1; i<counting.length; i++) {
        	if (counting[i] == 0) continue;
        	while (counting[i]-- > 0) {
        		sb.append(String.valueOf(i)+"\n");
        	}
        }
        bw.write(sb.toString());
		bw.flush();
	}
}
