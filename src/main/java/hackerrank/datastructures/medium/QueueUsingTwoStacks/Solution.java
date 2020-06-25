package hackerrank.datastructures.medium.QueueUsingTwoStacks;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        for (int i=0; i<n; i++) {
            int q = sc.nextInt();
            if (q == 1) { // enqueue
                int x = sc.nextInt();
                in.push(x);
            } else if (q == 2) { // dequeue
                if (out.isEmpty()) {
                    while (!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
                out.pop();
            } else if (q == 3) { // print queue
                if (out.isEmpty()) {
                    while (!in.isEmpty()) {
                        out.push(in.pop());
                    }
                }
                System.out.println(out.peek());
            }
        }
    }
}