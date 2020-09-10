package boj.Problem1181;

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

        String[] words = new String[N];
        for (int i=0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	words[i] = st.nextToken();
        }
		sort(words, 0, words.length-1);
		
		StringBuffer sb = new StringBuffer();
		String before = new String();
		for (String w: words) {
			if (!before.equals(w)) {
				sb.append(w + "\n");
				before = w;
			}
		}
		bw.write(sb.toString());
        
		bw.flush();
	}
	private static void sort(String[] arr, int l, int r) {
		if (l < r) {
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr, m+1, r);
			merge(arr, l, m+1, r);
		}
	}
	private static void merge(String[] arr, int l, int m, int r) {
		String[] sorted = new String[r-l+1];
		for (int i=0, j=l, k=m; i<sorted.length;) {
			if (k>r || j<m && lessThan(arr[j], arr[k]))
				sorted[i++] = arr[j++];
			else
				sorted[i++] = arr[k++];
		}
		for (int i=0; i<sorted.length; i++) {
			arr[i+l] = sorted[i];
		}
	}
	private static boolean lessThan(String a, String b) {
		if (a.length() < b.length())
			return true;
		if (a.length() > b.length())
			return false;
		for (int i=0; i<b.length(); i++) {
			if (a.charAt(i) < b.charAt(i))
				return true;
			else if (a.charAt(i) > b.charAt(i))
				return false;
		}
		return false;
	}
}