package Problem1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        int[] numbers = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        dp[1] = numbers[1];
        for (int i=2; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], 0) + numbers[i];
        }

        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}