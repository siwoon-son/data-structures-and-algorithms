package Problem1002;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0; i<t; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			System.out.println( countCoordinates(x1, y1, r1, x2, y2, r2) );
		}
	}
	private static int countCoordinates(int x1, int y1, int r1, int x2, int y2, int r2) {
		double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
		if (Math.abs(r1 - r2) < dist && dist < r1 + r2)	return 2;
		if (x1 == x2 && y1 == y2 && r1 == r2)	return -1;
		if (dist == r1 + r2 || dist == Math.abs(r1 - r2)) return 1;
		return 0;
	}
}
