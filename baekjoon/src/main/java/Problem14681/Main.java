package Problem14681;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());

		if (x > 0) {
			if (y > 0)	bw.write("1");
			else		bw.write("4");
		} else {
			if (y > 0)	bw.write("2");
			else		bw.write("3");
		}
		bw.newLine();
		
		bw.flush();
	}
}
