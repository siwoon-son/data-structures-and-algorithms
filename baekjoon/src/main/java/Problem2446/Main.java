package Problem2446;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		String stars = "";
		String spaces = "";
		for (int i=0; i<2*N+1; i++) {
			stars += "*";
		}
		// 별이 감소하는 구간
		for (int i=0; i<N; i++) {
			stars = stars.substring(0, stars.length()-2);
			sb.append(spaces + stars + "\n");
			spaces += " ";
		}
		spaces = spaces.substring(0, spaces.length()-1);
		// 별이 증하는 구간
		for (int i=N-1; i>0; i--) {
			stars += "**";
			spaces = spaces.substring(0, spaces.length()-1);
			sb.append(spaces + stars + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
	}
}
