package hackerrank.java.easy.JavaSubstring;

import java.util.*;

// https://www.hackerrank.com/challenges/java-substring/problem
public class JavaSubstring {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();
        System.out.println(S.substring(start,end));
    }
}
