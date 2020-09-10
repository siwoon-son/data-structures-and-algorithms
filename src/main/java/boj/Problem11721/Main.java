package boj.Problem11721;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next(); 
		sc.close();
		
		for (int i=0; i<s.length(); i++) {
			System.out.print(s.charAt(i));
			if (i % 10 == 9)
				System.out.println();
		}
	}
}
