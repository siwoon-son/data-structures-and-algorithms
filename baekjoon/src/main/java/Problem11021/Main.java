package Problem11021;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<=T; i++) {
	        st = new StringTokenizer(br.readLine());
	        int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bw.write("Case #" + String.valueOf(i) + ": " + String.valueOf(A + B));
			bw.newLine();
		}
		
		bw.flush();
	}
}
