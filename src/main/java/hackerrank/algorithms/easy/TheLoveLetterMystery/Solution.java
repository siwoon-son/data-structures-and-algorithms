package hackerrank.algorithms.easy.TheLoveLetterMystery;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the theLoveLetterMystery function below.
    static int theLoveLetterMystery(String s) {
        // 알파벳의 ASCII 값을 하나 줄이는 작업이 1-연산일 때,
        // 문자열 s가 palindrome이 될 수 있는 최소 연산 수는?
        // 양쪽 끝에서부터 서로 같은 문자가 되려면,
        // 두 문자의 ASCII 값 차이를 누적한 횟수만큼 연산이 필요다.
        int nOfOperations = 0;

        final int N = s.length();
        // 처음부터 중간까지 반복한다.
        for (int i=0; i<N/2; i++) {
            // 왼쪽부터 i번째와 오른쪽부터 i번째의 문자 간 ASCII 값 차이를 누적한다.
            nOfOperations += Math.abs(s.charAt(i) - s.charAt(N-i-1));
        }

        return nOfOperations;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = theLoveLetterMystery(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
