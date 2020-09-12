package algorithms.easy.Pangrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        // 문자열 s가 pangram인지 확인한다.
        // pangram이란 주어진 문자열에 모든 알파벳이 하나 이상 존재함을 의미한다.
        // 만약, i번째 위치에서 이미 pangram이면 더 이상 나머지 문자를 확인할 필요가 없다.
        // 또한, 문자마다 현재까지 pangram인지 확인하기 위해 모든 알파벳을 훑는 것은 효율적이지 않다.

        // 현재까지 어떤 문자가 발견되었는지 저장할 boolean 배열을 선언한다.
        // 알파벳의 개수인 26개로 선언한다.
        boolean[] alphabets = new boolean[26];
        // 현재까지 발견된 알파벳의 개수를 기억한다.
        int remaining = 26;

        for (char c: s.toCharArray()) {
            // 현재 문자가 공백이면 skip한다.
            if (c == ' ') continue;
            // 현재 문자가 대문자면 소문자로 변경한다.
            if (Character.isUpperCase(c)) c = Character.toLowerCase(c);
            // 현재 문자가 처음 발견된 알파벳이면,
            if (!alphabets[c - 'a']) {
                // 해당 문자를 발견한 것으로 기록하고,
                alphabets[c - 'a'] = true;
                // 발견된 알파벳을 하나 줄이는데
                // 지금까지 발견된 알파벳의 수가 26개, 즉 모든 알파벳을 발견했다면
                // 해당 문자열은 pangram이다.
                if (--remaining == 0) return "pangram";
            }
        }

        // 모든 문자를 훑었다면 pangram이 아니다.
        return "not pangram";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        String result = pangrams(s);

        System.out.println(result);

        scanner.close();
    }
}
