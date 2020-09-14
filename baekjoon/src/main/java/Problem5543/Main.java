package Problem5543;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st;

        int minHamburger = 2000;
        for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			int hamburger = Integer.parseInt(st.nextToken());
			minHamburger = Math.min(minHamburger, hamburger);
		}

		int minBeverage = 2000;
		for (int i=0; i<2; i++) {
			st = new StringTokenizer(br.readLine());
			int beverage = Integer.parseInt(st.nextToken());
			minBeverage = Math.min(minBeverage, beverage);
		}

		bw.write(String.valueOf(minHamburger + minBeverage - 50));
		bw.flush();
	}
}
