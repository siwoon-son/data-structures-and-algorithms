package hackerrank.algorithms.medium.ThePowerSum;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the powerSum function below.
    static int powerSum(int X, int N) {
        // 중복되지 않은 자연수들의 N 제곱 합이 X가 되는 조합의 개수를 계산한다.
        // 예를 들어, X=13 and N=2이면, 2^2 + 3^2의 조합이 유일하다. 따라서 1.

        // 1부터 조합에 포함하지 않거나 포함하며, 조합의 합이 X와 동일해지면 개수를 증가시킨다.
        return countPowerSum(X, N, 1);
    }

    private static int countPowerSum(int X, int N, int i) {
        // i^N 값을 미리 계산한다.
        int NSquared = pow(i, N);
        // i^N > X면, 현재 조합은 불가능하므로 개수를 증가시키지 않는다.
        if (NSquared > X) return 0;
        // i^N == X면, 가능한 조합이므로 개수를 1 증가시킨다.
        if (NSquared == X) return 1;
        // i^N < X면, i를 조합에 포함하지 않거나 포함한 경우로 나누어 i+1을 확인한다.
        return countPowerSum(X, N, i+1) +                  // i를 조합에 포함하지 않은 경우
                countPowerSum(X - NSquared, N, i+1);    // i를 조합에 포함한 경우
    }

    private static int pow(int i, int exp) {
        return (int) Math.pow(i, exp);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
