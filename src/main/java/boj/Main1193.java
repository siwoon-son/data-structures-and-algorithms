package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        int maxOfGroup = (int) (Math.sqrt(2.0*X-7.0/4.0)+(1.0/2.0));
        int headOfGroup = maxOfGroup*(maxOfGroup-1)/2 + 1;
        int diff = X-headOfGroup;
        int numerator = maxOfGroup%2==0? 1+diff : maxOfGroup-diff;
        int denominator = maxOfGroup - numerator + 1;
        
        bw.write(String.valueOf(numerator) + "/" + String.valueOf(denominator));
        
		bw.flush();
	}
}