package hackerrank.algorithms.easy.MarsExploration;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        // "SOS"가 연속되어야할 문자열 s의 일부 문자가 변경되었다.
        // 변경된 문자의 수를 반환한다.
        // 변경된 문자의 수를 저장할 변수를 0으로 초기화한다.
        int cntChanged = 0;

        for (int i=0; i<s.length(); i++) {
            // 인덱스 i를 3으로 나누었을때 나머지가 1이 아니면 해당 문자는 'S'여야 한다.
            if (i % 3 != 1 && s.charAt(i) != 'S') cntChanged++;
            // 인덱스 i를 3으로 나누었을때 나머지가 1이면 해당 문자는 'O'여야 한다.
            else if (i % 3 == 1 && s.charAt(i) != 'O') cntChanged++;
        }

        return cntChanged;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        int result = marsExploration(s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
