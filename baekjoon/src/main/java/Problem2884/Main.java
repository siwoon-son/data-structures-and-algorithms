package Problem2884;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int minutes = H * 60 + M - 45;
		if (minutes < 0) minutes += 24 * 60;

		bw.write(String.valueOf(minutes / 60) + " " + String.valueOf(minutes % 60));
		bw.newLine();
		
		bw.flush();
	}
}
