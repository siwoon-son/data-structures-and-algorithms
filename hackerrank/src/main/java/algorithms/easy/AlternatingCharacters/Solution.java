package algorithms.easy.AlternatingCharacters;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        // A와 B로 이루어진 문자열 s가 두 문자가 계속해서 교차할 수 있도록 지워야할 최소 문자수를 반환한다.
        // 이는 연속된 문자가 같은 횟수를 세는 문제와 같다.
        int nOfRemoved = 0;

        // 두 번째부터 마지막 문자까지 반복한다.
        for (int i=1; i<s.length(); i++) {
            // 현재 문자와 이전 문자가 같으면 문자 하나를 지워야한다.
            if (s.charAt(i) == s.charAt(i-1)) nOfRemoved++;
        }

        return nOfRemoved;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
