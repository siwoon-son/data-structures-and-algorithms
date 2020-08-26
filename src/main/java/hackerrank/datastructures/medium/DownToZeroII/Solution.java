package hackerrank.datastructures.medium.DownToZeroII;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the downToZero function below.
     */
    private static int[] downToZero = new int[1000001];

    static int downToZero(int n) {
        // 주어진 숫자 n은 다음 두가지 연산을 수행할 수 있다.
        // 1. n = a * b (a와 b는 1이 아니다.)이면, n = max(a, b)
        // 2. n을 1 감소시킨다.
        // n을 0으로 바꾸는 최소 연산 수를 계산하라.

        // 문제는 Queue지만, dp로 더 간단히 계산할 수 있다.

        // 특정 n에 대한 답뿐만 아니라,
        // 주어진 모든 질의를 답하기 위해 모든 n을 계산해두자.
        // 배열 downToZero에는 모든 n을 0으로 바꾸는 최소 수를 저장한다.
        if (downToZero[n] == 0) buildSolution();
        return downToZero[n];
    }
    private static void buildSolution() {
        // n=0이면, 최소 연산 수는 0이므로 계산하지 않으므로, 1부터 계산한다.
        // 1부터 최대 100만까지 계산한다.
        for (int i=1; i < 1000001; i++) {
            // 연산 2를 최소 수라 가정한다.
            int min = downToZero[i-1] + 1;
            // 2부터 n의 제곱근까지 반복하며, 최소 수를 계산한다.
            for (int j=2; j * j <= i; j++) {
                // 연산 1을 만족하면,
                if (i % j == 0) {
                    // 더 큰 숫자를 계산해서,
                    int quotient = i / j;
                    // 기존 최소 수와 비교하여 더 작은 값으로 갱신한다.
                    min = Math.min(min, downToZero[quotient] + 1);
                }
            }
            // 모든 반복이 끝나면 최소수를 n 위치에 저장한다.
            downToZero[i] = min;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
