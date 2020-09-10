package hackerrank.algorithms.medium.HighestValuePalindrome;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        // 참고: https://www.geeksforgeeks.org/make-largest-palindrome-changing-k-digits/
        // n 자리 숫자로 구성된 문자열 s에서
        // 최대 k개의 문자를 바꿔서 만들 수 있는 가장 큰 팰린드롬을 반환한다.

        // 문자열을 수정하도록 문자 배열로 변환한다.
        char[] chars = s.toCharArray();

        // 최소한의 change로 팰린드롬을 만든다.
        for (int l=0, r=n-1; l < r; l++, r--) {
            if (chars[l] != chars[r]) {
                chars[l] = chars[r] = (char) Math.max(chars[l], chars[r]);
                k -= 1;
            }
        }

        // 팰린드롬을 만들었는데 k가 음수면, 기존 k로는 팰린드롬을 만들 수 없다.
        if (k < 0) return "-1";

        // 가장 큰 팰린드롬으로 만든다.
        for (int l=0, r=n-1; l < r; l++, r--) {
            // 해당 자리 숫자가 이미 가장 큰 숫자인 '9'면 스킵한다.
            if (chars[l] == '9') continue;

            // k가 2회 이상 남았고, 기존에 변경하지 않았다면,
            // 양쪽 숫자를 '9'로 만들고 k를 2 감소시킨다.
            if (k >= 2 && chars[l] == s.charAt(l) && chars[r] == s.charAt(r)) {
                chars[l] = chars[r] = '9';
                k -= 2;
            }
            // k가 1회 이상 남았고, 기존에 변경한 적이 있다면,
            // 기존에 변경한 기회까지 포함하여
            // 양쪽 숫자를 9로 만들고 k는 1만 감소시킨다.
            else if (k >= 1 && (chars[l] != s.charAt(l) || chars[r] != s.charAt(r))) {
                chars[l] = chars[r] = '9';
                k -= 1;
            }
        }

        // 길이가 홀수이고 바꿀 기회가 남아있으면, 가운데 값을 '9'로 바꾼다.
        if (n % 2 == 1 && k > 0) {
            chars[n/2] = '9';
        }

        return String.valueOf(chars);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
