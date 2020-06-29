package hackerrank.algorithms.easy.CountingValleys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // 이동할 때마다 상태를 저장할 enum을 생성한다.
    // 순서대로 해수면, 산, 계곡을 의미한다.
    enum STATE {SEA_LEVEL, MOUNTAIN, VALLEY};
    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        // 현 위치의 고도와 상태를 해수면으로 초기화한다.
        int altitude = 0;
        STATE prev = STATE.SEA_LEVEL;
        // 계곡의 수를 0으로 초기화한다.
        int nValley = 0;

        // 이동 경로를 하나씩 읽는다.
        for (char c: s.toCharArray()) {
            // 현재의 step이 U면 고도를 올리고,
            if (c == 'U') altitude ++;
            // 현재의 setp이 D면 고도를 낮춘다.
            else if (c == 'D') altitude --;

            // 직전의 상태가 계곡이면서 현재의 고도가 0이면 계곡의 수를 증가시킨다.
            if (prev == STATE.VALLEY && altitude == 0) nValley++;

            // 고도가 0보다 크면 상태를 산으로,
            if (altitude > 0) prev = STATE.MOUNTAIN;
            // 고도가 0보다 작으면 상태를 계곡으로,
            else if (altitude < 0) prev = STATE.VALLEY;
            // 고도가 0이면 상태를 해수면으로 기록한다.
            else prev = STATE.SEA_LEVEL;
        }

        return nValley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
