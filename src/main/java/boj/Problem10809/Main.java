package boj.Problem10809;

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
        String S = st.nextToken();
        int[] result = new int[26];
        for (int i=S.length()-1; i>=0; i--) {
        	result[S.charAt(i)-'a'] = i+1;
        }
        
        bw.write(String.valueOf(result[0]-1));
        for (int i=1; i<result.length; i++) {
        	bw.write(" " + String.valueOf(result[i]-1));
        }
		bw.flush();
	}
}
