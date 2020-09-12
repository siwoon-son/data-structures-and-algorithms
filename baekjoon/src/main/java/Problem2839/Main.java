package Problem2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.close();

		for (int five = N / 5; five > 0; five--) {
			if ((N - five * 5) % 3 == 0) {
				System.out.println(five + ((N - five * 5) / 3));
				return;
			}
		}
		if (N % 3 == 0) {
			System.out.println(N / 3);
			return;
		}
		System.out.println(-1);
	}
}
