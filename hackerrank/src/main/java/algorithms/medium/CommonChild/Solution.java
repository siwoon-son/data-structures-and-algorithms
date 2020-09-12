package algorithms.medium.CommonChild;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        int[] freqs = new int[26];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int N = c1.length;

        for (char c: c1) {
            freqs[c - 'A']++;
        }

        int longest = 0;
        for (int i=0; i<N; i++) {
            int length = 0;
            int idx = 0;
            for (int j=i; j<N; j++) {
                while (idx < N) {
                    if (c1[idx] != c2[j]) idx++;
                    else break;
                }
                if (idx == N) break;
                idx++;
                length++;
            }
            longest = Math.max(longest, length);
        }

        return longest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
