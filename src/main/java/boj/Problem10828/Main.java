package boj.Problem10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());

		Stack<Integer> stack = new Stack<Integer>();
        for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String op = st.nextToken();
			switch (op) {
				case "push":
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case "pop":
					int pop = -1;
					if (!stack.empty())
						pop = stack.pop();
					System.out.println(pop);
					break;
				case "size":
					System.out.println(stack.size());
					break;
				case "empty":
					System.out.println(stack.isEmpty() ? 1 : 0);
					break;
				case "top":
					int top = -1;
					if (!stack.empty())
						top = stack.peek();
					System.out.println(top);
					break;
			}
		}
	}
}