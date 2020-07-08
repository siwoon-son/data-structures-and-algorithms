package hackerrank.algorithms.easy.CamelCase;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the camelcase function below.
    static int camelcase(String s) {
        // CamelCase 문자열 s에서 단어의 개수를 반환한다.
        // s의 길이는 1보다 크거나 같다.
        // 즉, 단어가 반드시 하나 이상 존재한다.
        // 단어의 개수인 count를 1로 초기화한다
        int count = 1;

        // 문자열을 순회하며 대문자가 나타날때마다 count를 증가시킨다.
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') count++;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        int result = camelcase(s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
