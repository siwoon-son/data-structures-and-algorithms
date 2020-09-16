package Problem3009;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// (x, y) 좌표가 3개 주어졌을 때, 사각형을 이루는 나머지 한 점을 찾는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());

		int x4 = x1 == x2 ? x3 : x1 == x3 ? x2 : x1;
		int y4 = y1 == y2 ? y3 : y1 == y3 ? y2 : y1;

        bw.write(x4 + " " + y4);
		bw.flush();
	}
}
