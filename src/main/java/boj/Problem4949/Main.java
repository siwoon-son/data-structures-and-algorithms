package boj.Problem4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
        do {
        	s = s.replaceAll("[^\\(\\)\\[\\]]", "");
			Stack<Character> stack = new Stack<Character>();
			int i = 0;
			for (; i<s.length(); i++) {
				char cur = s.charAt(i);
				if (cur == '(' || cur == '[') stack.push(cur);
				else if ((cur == ')' || cur == ']') && stack.isEmpty()) break;
				else if (cur == ')' && stack.pop() != '(') break;
				else if (cur == ']' && stack.pop() != '[') break;
			}
			System.out.println(stack.isEmpty() && i == s.length() ? "yes" : "no");
			s = br.readLine();
		} while (!s.equals("."));
	}
}