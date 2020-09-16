package Problem1085;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 직사각형 w*h로부터 (x, y)점에서 가장 가까운 경계선까지의 거리를 계산한다.
		// 간단히 min(x, y, w-x, h-w)를 출력한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.min(x, Math.min(y, Math.min(w-x, h-y)))));
		bw.flush();
	}
}
