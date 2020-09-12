package Problem1003;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = sc.nextInt(); t>0; t--) {
			int n = sc.nextInt();
			if (n == 0)	{
				System.out.println(1 + " " + 0);
				continue ;
			}
			int prev = 0, now = 1;
			for (int i=0; i<n-1; i++) {
				int next = prev + now;
				prev = now;
				now = next;
			}
			System.out.println(prev + " " + now);
		}
	}
}