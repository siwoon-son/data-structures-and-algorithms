package Problem10952;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();

		while (!input.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input);
	        int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bw.write(String.valueOf(A + B));
			bw.newLine();

			input = br.readLine();
		}
		
		bw.flush();
	}
}
