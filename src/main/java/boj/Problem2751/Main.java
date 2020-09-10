package boj.Problem2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N];

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		sort(numbers, 0, numbers.length-1);
		
		StringBuffer sb = new StringBuffer();
		for (int n: numbers) {
			sb.append(n + "\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
	}
	private static void sort(int[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m+1, r);
		}
	}
	private static void merge(int[] arr, int l, int m, int r) {
		int[] sorted = new int[r-l+1];
		for (int i=0, j=l, k=m; i<sorted.length;) {
			if (k>r || j<m && arr[j] < arr[k])
				sorted[i++] = arr[j++];
			else
				sorted[i++] = arr[k++];
		}
		for (int i=0; i<sorted.length; i++) {
			arr[i+l] = sorted[i];
		}
	}
}