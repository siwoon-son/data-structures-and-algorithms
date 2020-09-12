package Problem5622;

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
        String dial = st.nextToken();
        
        int time = 0;
        for (int i=0; i<dial.length(); i++) {
        	char c = dial.charAt(i);
        	if ('A' <= c && c <= 'C')		time += 3;
        	else if ('D' <= c && c <= 'F')	time += 4;
        	else if ('G' <= c && c <= 'I')	time += 5;
        	else if ('J' <= c && c <= 'L')	time += 6;
        	else if ('M' <= c && c <= 'O')	time += 7;
        	else if ('P' <= c && c <= 'S')	time += 8;
        	else if ('T' <= c && c <= 'V')	time += 9;
        	else if ('W' <= c && c <= 'Z')	time += 10;
        }
        
        bw.write(String.valueOf(time));
		bw.flush();
	}
}
