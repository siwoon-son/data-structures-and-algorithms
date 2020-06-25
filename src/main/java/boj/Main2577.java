package boj;

import java.io.IOException;
import java.util.Scanner;

public class Main2577 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		sc.close();
		
		int multi = A * B * C;
		int[] times = new int[10];
		while (multi > 0) {
			times[multi%10] ++;
			multi /= 10;
		}
		for (int count: times)
			System.out.println(count);
	}
}
