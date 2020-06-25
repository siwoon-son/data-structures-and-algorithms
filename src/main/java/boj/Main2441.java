package boj;

import java.util.Scanner;

public class Main2441 {
	private enum WEEK {
		SUN, MON, TUE, WED, THU, FRI, SAT
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.close();
		
		for (int i=1; i<x; i++) {
			switch (i) {
			case 2:
				y += 28;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				y += 30;
				break;
			default :
				y += 31;
				break;
			}
		}
		
		System.out.println(WEEK.values()[y % 7]);
	}
}
