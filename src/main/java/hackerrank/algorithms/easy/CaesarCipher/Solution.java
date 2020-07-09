package hackerrank.algorithms.easy.CaesarCipher;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the caesarCipher function below.
    static String caesarCipher(String s, int k) {
        // Caesar Cipher에 따라, 문자열 s를 암호화한다.
        // 이는 알파벳 문자들을 왼쪽으로 k번 shift하고, 문자열 s의 문자들을 대응하는 문자로 치환한다.

        // 암호화된 문자열을 저장할 StringBuilder를 생성한다.
        StringBuilder encrypted = new StringBuilder();
        for (char c: s.toCharArray()) {
            // 대문자일 경우,
            if (Character.isUpperCase(c)) {
                encrypted.append( (char) ((c - 'A' + k) % 26 + 'A') );
            }
            // 소문자일 경우,
            else if (Character.isLowerCase(c)) {
                encrypted.append( (char) ((c - 'a' + k) % 26 + 'a') );
            }
            // 특수문자일 경우,
            else {
                // 그대로 추가한다.
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = caesarCipher(s, k);

        System.out.println(result);

        scanner.close();
    }
}
