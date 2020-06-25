package hackerrank.algorithms.easy.PalindromeIndex;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the palindromeIndex function below.
    static int palindromeIndex(String s) {
        int ret = -1;
        int l = 0;
        int r = s.length()-1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) break;
            l++; r--;
        }
        if (l == r) return ret;

        // remove one left-side element.
        ret = l;
        for (int i=l+1, j=r; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                ret = -1;
                break;
            }
        }
        if (ret != -1) return ret;

        // remove one left-side element.
        ret = r;
        for (int i=l, j=r-1; i<j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                ret = -1;
                break;
            }
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = palindromeIndex(s);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
