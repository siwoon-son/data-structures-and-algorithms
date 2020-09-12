package algorithms.easy.FunnyString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the funnyString function below.
    static String funnyString(String s) {
        // 문자열 s가 funny인지 확인한다.
        // funny 문자열이란 이웃한 문자들의 ASCII값의 차이가 대칭임을 의미한다.
        // e.g. s = "lmnop"일때, s = [108, 109, 110, 111, 112]이다.
        // reverse s는 [112, 111, 110, 109, 108]이므로,
        // 이웃한 문자들의 ASCII차이는 [1, 1, 1, 1]이므로 같다.

        // 문자열의 문자들을 추출한다.
        char[] chars = s.toCharArray();

        // 왼쪽 인덱스와 오른쪽 인덱스를 초기화한다.
        int l = 0, r = s.length()-1;
        // 왼쪽 인덱스가 오른쪽 인덱스보다 작은 동안 반복한다.
        while (l < r) {
            // 왼쪽 인덱스의 이웃값 차가 오른쪽 인덱스의 이웃값 차와 다르다면,
            if (Math.abs(chars[l] - chars[l+1]) != Math.abs(chars[r] - chars[r-1]))
                // funny하지 않다.
                return "Not Funny";
            // 인덱스를 하나씩 이동시킨다.
            l++; r--;
        }
        return "Funny";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
