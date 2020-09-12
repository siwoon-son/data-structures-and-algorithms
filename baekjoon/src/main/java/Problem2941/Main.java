package Problem2941;

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
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
        	if (i+1 < s.length() && s.substring(i, i+2).equals("c=")) {
        		cnt++; i++;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("c-")) {
        		cnt++; i++;
        	} else if (i+2 < s.length() && s.substring(i, i+3).equals("dz=")) {
        		cnt++; i+=2;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("d-")) {
        		cnt++; i++;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("lj")) {
        		cnt++; i++;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("nj")) {
        		cnt++; i++;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("s=")) {
        		cnt++; i++;
        	} else if (i+1 < s.length() && s.substring(i, i+2).equals("z=")) {
        		cnt++; i++;
        	} else {
        		cnt++;
        	}
        }
        
        bw.write(String.valueOf(cnt));
		bw.flush();
	}
}
