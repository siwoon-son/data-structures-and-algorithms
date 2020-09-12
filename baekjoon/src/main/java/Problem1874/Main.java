package Problem1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.valueOf(br.readLine());
		int[] numbers = new int[N];
		for (int i=0; i<N; i++) {
			numbers[i] = Integer.valueOf(br.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();
		StringBuffer sb = new StringBuffer();
		int last = 1;
		for (int i=0; i<N; i++) {
			while (last<=numbers[i]) {
				stack.push(last++);
				sb.append("+\n");
			}
			if (stack.pop() != numbers[i]) {
				last = -1;
				break;
			}
			sb.append("-\n");
		}
		System.out.println(last > N ? sb.toString() : "NO");
	}
}