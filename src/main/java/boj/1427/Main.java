package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        int[] count = new int[10];
        while (N > 0) {
        	count[N%10]++;
        	N/=10;
        }
        for (int i=0, j=1; i<count.length; i++) {
        	while (count[i]-- > 0) {
        		N+=i*j;
        		j*=10;
        	}
        }
        bw.write(String.valueOf(N));
		bw.flush();
	}
}
