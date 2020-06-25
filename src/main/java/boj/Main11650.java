package boj;

import java.io.*;
import java.util.*;

// x * 1000000 + y를 하나의 long type으로 저장해서 정렬하는 성능 높은 방법도 있다.
public class Main11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // input data
		int[][] coordinates = new int[T][2];
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coordinates[i] = new int[]{x, y};
		}

		// sort
		Arrays.sort(coordinates, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0]) return 1;
				if (o1[0] < o2[0]) return -1;
				if (o1[1] > o2[1]) return 1;
				if (o1[1] < o2[1]) return -1;
				return 0;
			}
		});

		// print
		for (int[] c: coordinates)
			bw.write(String.valueOf(c[0] + " " + c[1] + "\n"));

		bw.flush();
	}
}