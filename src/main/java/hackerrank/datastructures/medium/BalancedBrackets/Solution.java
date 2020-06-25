package hackerrank.datastructures.medium.BalancedBrackets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.isEmpty()) return "NO";
            else if (c == ')' && stack.pop() != '(') return "NO";
            else if (c == '}' && stack.pop() != '{') return "NO";
            else if (c == ']' && stack.pop() != '[') return "NO";
        }

        return stack.isEmpty() ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
