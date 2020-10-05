package Problem1436;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 영화감독 숌
		// N번째 "666"이 포함된 숫자를 찾는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        // 숫자를 하나씩 증가시키며,
		// 666을 포함하는 경우의 갯수를 세고 마지막 숫자를 출력한다.
        int name = 665;
        while (N > 0) {
        	name++;
        	if (String.valueOf(name).contains("666")) {
        		N--;
			}
		}

        bw.write(String.valueOf(name));
		bw.flush();
	}
}
