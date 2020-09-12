package algorithms.easy.MakingAnagrams;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        // 두 문자열에 속한 문자가 같은 빈도수를 가지면 anagram이라고 한다.
        // 문자열 s1과 s2이 anagram이 되도록 제거해야할 문자수를 반환한다.

        // 문자열 s1의 빈도수를 저장하고, s2의 빈도수를 뺀다.
        // 그 후의 빈도수 절대값을 모두 더한다.

        // 알파벳의 빈도수를 저장할 배열을 선언한다.
        int[] freqs = new int[26];

        // 문자열 s1의 빈도수를 저장한다.
        for (char c: s1.toCharArray()) {
            freqs[c - 'a'] ++;
        }
        // 문자열 s2의 빈도수를 뺀다.
        for (char c: s2.toCharArray()) {
            freqs[c - 'a'] --;
        }

        // 빈도수에 기록된 숫자들의 절대값을 더한다.
        int nOfRemoved = 0;
        for (int i: freqs) {
            nOfRemoved += Math.abs(i);
        }

        return nOfRemoved;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
