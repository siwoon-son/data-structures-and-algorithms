package Problem5543;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        // 햄버거의 최소값
        int minHamburger = 2000;
        for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int hamburger = Integer.parseInt(st.nextToken());
			minHamburger = Math.min(minHamburger, hamburger);
		}

        // 음료의 최소값
		int minBeverage = 2000;
		for (int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			int beverage = Integer.parseInt(st.nextToken());
			minBeverage = Math.min(minBeverage, beverage);
		}

		// 세트 할인
		bw.write(String.valueOf(minHamburger + minBeverage - 50));
		bw.flush();
	}
}
