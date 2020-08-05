package hackerrank.algorithms.medium.SherlockAndTheValidString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        // a-z로 구성된 문자열에서 모든 알파벳의 빈도수가 같으면 valid하다.
        // 이때, 최대 하나의 문자만 지워서 valid할 수 있는지 확인한다.

        // 먼저, 각 알파벳의 빈도수를 계산한다.
        int[] alphabets = new int[26];
        for (char c: s.toCharArray()) {
            alphabets[c - 'a']++;
        }

        // 알파벳 빈도수의 갯수를 집계한다.
        Map<Integer, Integer> counts = new HashMap<>();
        for (int n: alphabets) {
            if (n == 0) continue;
            Integer count = counts.get(n);
            if (count == null) {
                count = 0;
            }
            count++;
            counts.put(n, count);
        }

        // 빈도수가 모두 같으면, valid
        if (counts.size() == 1) return "YES";
        // 서로 다른 빈도수가 3개 이상이면, not valid
        if (counts.size() > 2) return "NO";

        // 서로 다른 빈도수가 2개만 있으면,
        List<Integer> keys = new ArrayList<>(counts.keySet());
        // 1개짜리 문자가 1개만 있으면, valid
        if (keys.get(0) == 1 && counts.get(keys.get(0)) == 1) return "YES";
        // 두 빈도수의 차이가 1이고, 더 많은 빈도수가 알파벳 하나이면, valid
        if (keys.get(1) - keys.get(0) == 1 && counts.get(keys.get(1)) == 1) return "YES";

        // 나머지는 not valid
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
