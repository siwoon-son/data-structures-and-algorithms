package Problem1157;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
		String S = st.nextToken();
		
		Map<Character, Integer> tokens = new HashMap();
		for (int i=0; i<S.length(); i++) {
			char c = Character.toLowerCase(S.charAt(i));
			if (!tokens.containsKey(c))
				tokens.put(c, 1);
			else
				tokens.put(c, tokens.get(c)+1); 
		}
		
		String result = "";
		int first = 0, second = 0;
		for (Character token: tokens.keySet()) {
			if (tokens.get(token) >= first) {
				second = first;
				first = tokens.get(token);
				result = String.valueOf(token);
			}
		}
		if (first == second)
			bw.write("?");
		else
			bw.write(result.toUpperCase());
		
		bw.flush();
	}
}
