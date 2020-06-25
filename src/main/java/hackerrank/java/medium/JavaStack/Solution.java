package hackerrank.java.medium.JavaStack;

import java.util.*;

// https://www.hackerrank.com/challenges/java-stack/problem
class Solution {
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
            String input=sc.next();
            // my code
            Stack<Character> stack = new Stack<Character>();
            boolean isBalanced = true;
            for (char c: input.toCharArray()) {
                // open parentheses
                if (c == '[' || c == '{' || c == '(') {
                    stack.push(c);
                    continue;
                }
                // If an open parentheses is not exists, return false.
                else if (stack.empty()) isBalanced = false;
                // close parentheses
                // If the parentheses are not balanced, return false.
                else if (c == ']' && stack.pop() != '[') isBalanced = false;
                else if (c == '}' && stack.pop() != '{') isBalanced = false;
                else if (c == ')' && stack.pop() != '(') isBalanced = false;
                // The parentheses are balanced.
                else continue;
                break;
            }
            if (!stack.empty()) isBalanced = false;
            System.out.println(isBalanced);
            // end
		}
		
	}
}



