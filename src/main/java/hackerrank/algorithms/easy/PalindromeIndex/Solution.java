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
        // 주어진 문자열 s에서 문자 하나를 제거했을 때 palindrome이 되는 문자의 인덱스를 반환한다.
        // 만약, 이미 palindrome이거나 답이 없으면 -1을 반환한다.
        // 따라서, 결과값을 -1로 초기화한다.
        int ret = -1;
        // 왼쪽과 오른쪽 인덱스를 초기화한다.
        int l = 0;
        int r = s.length()-1;

        // 이미 palindrome인지 확인한다.
        // 만약, palindrome이 아니면 l과 r에 일치하지 않는 인덱스가 저장된다.
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) break;
            l++; r--;
        }
        if (l == r) return ret;

        // 일치하지 않는 위치에서 왼쪽(l)의 값을 제거한다고 가정한다.
        ret = l;
        for (int i=l+1, j=r; i<j; i++, j--) {
            // 제거 후에도 일치하지 않으면(즉, 왼쪽 값을 제거하는게 답이 아니면),
            // ret를 다시 -1로 초기화한다. 
            if (s.charAt(i) != s.charAt(j)) {
                ret = -1;
                break;
            }
        }
        // 왼쪽 값을 제거하는게 답이면 그 인덱스를 반환한다.
        if (ret != -1) return ret;

        // 일치하지 않는 위치에서 오른쪽(r)의 값을 제거한다고 가정한다.
        ret = r;
        for (int i=l, j=r-1; i<j; i++, j--) {
            // 제거 후에도 일치하지 않으면(즉, 오른쪽 값을 제거하는게 답이 아니면),
            // ret를 다시 -1로 초기화한다.
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
