package hackerrank.algorithms.easy.Gemstones;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        // arr[i]는 a부터 z까지 문자로 이루어져 있는데,
        // 모든 문자열들의 공통적인 문자 수를 반환한다.
        // 즉, 문자들의 교집합을 반환한다.

        // 첫 번째 문자열의 집합을 가져온다.
        Set<Character> first = stringToSet(arr[0]);

        // 나머지 문자열과 교집합한다.
        for (int i=1; i<arr.length; i++) {
            first.retainAll(stringToSet(arr[i]));
        }

        // 남은 문자의 수를 반환한다.
        return first.size();
    }

    private static Set<Character> stringToSet(String str) {
        Set<Character> alphabets = new HashSet<>();
        for (char c: str.toCharArray()) {
            alphabets.add(c);
        }
        return alphabets;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
