package hackerrank.algorithms.easy.DesignerPDFViewer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        // 문자열 word를 highlight할 블록의 면적을 반환한다.
        // word에서 가장 긴 문자의 높이를 찾는다.
        int highest = 0;
        for (char c: word.toCharArray()) {
            highest = Math.max(highest, h[c - 'a']);
        }

        // 최대 높이와 문자열 길이를 곱해서 면적을 계산한다.
        return highest * word.length();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[] h = new int[26];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
