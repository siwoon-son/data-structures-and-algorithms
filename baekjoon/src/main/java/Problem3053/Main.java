package Problem3053;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 유클리드 기하학에서 원의 넓이와 택시 기하학에서 원의 넓이를 계산한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());

        bw.write(Math.PI*R*R + " " + 2*R*R);
		bw.flush();
	}
}
