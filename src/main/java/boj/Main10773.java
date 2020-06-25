package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
        for (int i=1; i<=N; i++) {
			int v = Integer.valueOf(br.readLine());
			if (v == 0) stack.pop();
			else stack.push(v);
		}

        int sum = 0;
        while (!stack.empty())
        	sum += stack.pop();
		System.out.println(sum);
	}
}