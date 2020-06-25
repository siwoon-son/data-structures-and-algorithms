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
        Set<Integer> weights = new HashSet<Integer>();
        for (int i=0; i<s.length();) {
            int contiguous = 1;
            char letter = s.charAt(i);
            while (i + contiguous < s.length()) {
                if (s.charAt(i + contiguous) != letter) break;
                contiguous++;
            }
            i += contiguous;
            for (int j=1; j<=contiguous; j++) {
                weights.add((letter - 'a' + 1)*j);
            }
        }

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
