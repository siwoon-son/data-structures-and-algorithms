package Problem2753;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		int year = Integer.parseInt(st.nextToken());

		bw.write((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ? "1" : "0");
		bw.newLine();
		
		bw.flush();
	}
}
