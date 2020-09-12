// cite https://github.com/charles-wangkai/hackerrank/blob/master/simple-text-editor/Solution.java

package datastructures.medium.SimpleTextEditor;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Q = sc.nextInt();
        Stack<Operator> operators = new Stack<>();
        StringBuilder s = new StringBuilder();
        for (int i=0; i<Q; i++) {
            int op = sc.nextInt();
            if (op == 1) {
                String w = sc.next();
                operators.push(new Operator(1, w.length()));
                s.append(w);
            } else if (op == 2) {
                int k = sc.nextInt();
                String deleted = s.substring(s.length()-k);
                operators.push(new Operator(2, deleted));
                s.delete(s.length()-k, s.length());
            } else if (op == 3) {
                int k = sc.nextInt();
                System.out.println(s.charAt(k-1));
            } else if (op == 4) {
                Operator undo = operators.pop();
                if (undo.op == 1) {
                    s.delete(s.length() - (int) undo.param, s.length());
                } else {
                    s.append(undo.param);
                }
            }
        }
    }
    private static class Operator {
        int op;
        Object param;
        public Operator (int op, Object param) {
            this.op = op;
            this.param = param;
        }
    }
}