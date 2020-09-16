package Problem4153;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

		String input;
		while (!(input = br.readLine()).equals("0 0 0")) {
			String[] triple = input.split(" ");
			int a = Integer.parseInt(triple[0]);
			int b = Integer.parseInt(triple[1]);
			int c = Integer.parseInt(triple[2]);

			boolean isRight = false;
			if (a > b && a > c) {
				isRight = a*a == b*b + c*c;
			} else if (b > a && b > c) {
				isRight = b*b == a*a + c*c;
			} else if (c > a && c > b) {
				isRight = c*c == a*a + b*b;
			}
			sb.append(isRight ? "right" : "wrong").append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}
}
