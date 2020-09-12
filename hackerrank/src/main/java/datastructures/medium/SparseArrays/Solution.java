package datastructures.medium.SparseArrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] freqs = new int[queries.length];
        Map<String, Integer> counts = new HashMap<String, Integer>();
        
        for (int i=0; i<strings.length; i++) {
            Integer count = counts.get(strings[i]);
            if (count == null) {
                count = 0;
            }
            counts.put(strings[i], ++count);
        }

        for (int i=0; i<queries.length; i++) {
            Integer count = counts.get(queries[i]);
            freqs[i] = ( count == null ? 0 : count );
        }

        return freqs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            System.out.print(String.valueOf(res[i]));

            if (i != res.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
