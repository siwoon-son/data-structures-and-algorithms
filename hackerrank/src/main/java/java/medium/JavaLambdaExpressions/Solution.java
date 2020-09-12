package java.medium.JavaLambdaExpressions;

import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-lambda-expressions/problem
// my code
// Functional interface
interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    public PerformOperation isOdd() {
        // the better source code for odd number.
        // return (num) -> num % 2 != 0;
        return (num) -> (num & 1) == 1;
    }
    public PerformOperation isPrime() {
        return (num) -> {
            if (num < 2) return false;
            // for (int i=2; i<=num/2; i++) {
            // the better source code for prime number.
            for (int i=2; i<=(int) Math.sqrt(num); i++) {
                if (num % i == 0)  return false;
            }
            return true;
        };
    }
    public PerformOperation isPalindrome() {
        return (num) -> {
            // the number of [0,9]
            int size = (int) Math.log10(num) + 1;
            // split the num
            int[] split = new int[size];
            for (int i=0; i<size; i++) {
                split[i] = num % 10;
                num /= 10;
            }
            // compare left and right sides.
            for (int i=0; i<size/2; i++) {
                if (split[i] != split[size-i-1]) return false;
            }
            return true;
        };
    }
}
// end

public class Solution {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
