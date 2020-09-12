package Problem11053;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dp = new int[n];

        int maxLen = 1;
        for (int i=0; i<n; i++) {
        	arr[i] = sc.nextInt();
        	dp[i] = 1;

        	int max = 0;
        	for (int j=0; j<i; j++) {
        		if (arr[j] < arr[i] && max < dp[j])
        			max = dp[j];
			}
        	dp[i] = max + 1;

        	maxLen = Math.max(maxLen, dp[i]);
		}

		System.out.println(maxLen);
	}
}