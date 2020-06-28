package hackerrank.algorithms.easy.WeightedUniformStrings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {
        // 문자열 s에서 각 문자의 ASCII 값들에 queries 값이 포함되면 Yes, 안되면 No를 반환한다.
        // 이때, 연속된 같은 문자는 그 갯수만큼 중복하여 저장할 수 있다.
        // 예를 들어, aaa는 1, 2(1+1), 3(1+1+1)이 저장된다.

        // queries를 가장 빠르게 검색하기 위해, 문자들의 weight를 저장할 Set을 생성한다.
        Set<Integer> weights = new HashSet<Integer>();
        for (int i=0; i<s.length();) {
            // 연속된 같은 문자의 수를 1로 초기화한다.
            int contiguous = 1;
            // 현재 위치의 문자를 가져온다.
            char letter = s.charAt(i);
            // 연속된 같은 문자의 수를 측정한다.
            while (i + contiguous < s.length()) {
                if (s.charAt(i + contiguous) != letter) break;
                contiguous++;
            }
            // 인덱스를 연속된 같은 문자의 수만큼 이동한다.
            i += contiguous;
            // 연속된 수만큼 ASCII 값을 Set에 저장한다.
            for (int j=1; j<=contiguous; j++) {
                weights.add((letter - 'a' + 1)*j);
            }
        }

        // Set에 queries가 있으면 Yes, 없으면 No를 문자열 리스트에 저장한다.
        String[] ret = new String[queries.length];
        for (int i=0; i<queries.length; i++) {
            ret[i] = weights.contains(queries[i]) ? "Yes" : "No";
        }
        return ret;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        String[] result = weightedUniformStrings(s, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();
        scanner.close();
    }
}
