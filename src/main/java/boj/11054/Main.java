package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_d = new int[N + 1];
        dp_d[1] = 1;
        for (int i = 1; i <= N; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j] && max < dp_d[j]) {
                    max = dp_d[j];
                }
            }
            dp_d[i] = max + 1;
        }

        int[] dp_r = new int[N + 1];
		for (int i = N; i >= 1; i--) {
			int max = 0;
			for (int j = N; j > i; j--) {
				if (arr[i] > arr[j] && max < dp_r[j]) {
					max = dp_r[j];
				}
			}
			dp_r[i] = max + 1;
		}

		int maxLen = 0;
		for (int i=1; i<=N; i++) {
			maxLen = Math.max(maxLen, dp_d[i]+dp_r[i]-1);
		}
        System.out.println(maxLen);
    }
}