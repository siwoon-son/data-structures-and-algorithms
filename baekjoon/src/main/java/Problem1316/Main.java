package Problem1316;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int cnt = 0;
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if (isGroupNumber(s)) cnt++;
		}
		bw.write(String.valueOf(cnt));
		bw.flush();
	}

	private static boolean isGroupNumber(String s) {
		Set<Character> alpha = new HashSet<Character>();
		for (int i=0; i<s.length();) {
			char c = s.charAt(i);
			if (alpha.contains(c)) return false;
			alpha.add(c);
			while (++i<s.length() && s.charAt(i) == c);
		}
		return true;
	}
}
