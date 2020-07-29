package hackerrank.datastructures.medium.BiggerIsGreater;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        // 주어진 문자열 w의 문자 순서를 바꿔 사전적으로 한 단계 더 큰 문자열을 반환한다.
        // 중요! 부분문자열의 문자들이 내림차순이면 가장 큰 문자열이다.
        // 알고리즘은 다음과 같이 동작한다.
        // 첫째, 문자열의 가장 오른쪽부터 왼쪽으로 이동하며, 오름차순이 아닌 문자(x)의 위치를 찾는다.
        // 둘째, x를 기준으로, 오른쪽 문자들 중 더 크지만 가장 작은 값(y)의 위치를 찾는다.
        // 셋째, x와 y를 서로 바꾼다.
        // 넷째, x를 기준으로, 오른쪽 문자들을 오름차순으로 정렬한다.

        char[] chars = w.toCharArray();

        // 첫째
        int idxNotDescending = getIdxRightMostNotDescending(chars);
        if (idxNotDescending == -1) return "no answer";

        // 둘째
        int idxSmallestLargerValue = getIdxSmallestLargerValueInRight(chars, idxNotDescending);

        // 셋째
        swap(chars, idxNotDescending, idxSmallestLargerValue);

        // 넷째
        Arrays.sort(chars, idxNotDescending+1, chars.length);

        return String.valueOf(chars);
    }

    private static int getIdxRightMostNotDescending (char[] chars) {
        for (int i=chars.length-1; i>=1; i--) {
            if (chars[i-1] < chars[i])
                return i-1;
        }
        return -1;
    }

    private static int getIdxSmallestLargerValueInRight (char[] chars, int curr) {
        int idx = curr + 1;
        for (int i=idx; i<chars.length; i++) {
            if (chars[i] > chars[curr] && chars[i] < chars[idx])
                idx = i;
        }
        return idx;
    }

    private static void swap (char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = scanner.nextLine();

            String result = biggerIsGreater(w);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
