package Problem9375;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// 주어진 옷들로 만들 수 있는 조합을 계산한다.
		// (A 타입 옷 + 1)*(B 타입 옷 + 1)*...*(X 타입 옷 + 1) - 1
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			Map<String, Integer> counts = new HashMap<>();
			for (int i=0; i<n; i++) {
				String cloth = br.readLine().split(" ")[1];
				int count = 0;
				if (counts.containsKey(cloth)) {
					count = counts.get(cloth);
				}
				counts.put(cloth, count+1);
			}

			int cases = 1;
			for (Map.Entry<String, Integer> entry: counts.entrySet()) {
				cases *= entry.getValue()+1;
			}
			sb.append(cases-1).append("\n");
		}

        bw.write(sb.toString());
		bw.flush();
	}

}
