package boj.Problem9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

        for (int i=1; i<=N; i++) {
			String x = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			int j = 0;
			for (; j<x.length(); j++) {
				char cur = x.charAt(j);
				if (cur == '(') stack.push(cur);
				else if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
				else break;
			}
			System.out.println(stack.isEmpty() && j==x.length() ? "YES" : "NO");
		}
	}
}