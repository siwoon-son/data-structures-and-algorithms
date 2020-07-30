package hackerrank.algorithms.medium.AbsolutePermutation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        // 1..n으로 구성된 배열에서 인덱스와 값의 차이가 k가 되도록 배열을 재배치한다.
        // 먼저, 1..n의 모든 자연수를 Set에 저장한다.
        Set<Integer> numbers = new HashSet<>();
        for (int i=1; i<=n; i++)
            numbers.add(i);

        // 재배치할 배열을 생성한다.
        int[] ret = new int[n];
        for (int i=0; i<n; i++) {
            // 1..n 숫자에서 k를 뺀 값이 Set에 있으면,
            if (numbers.contains((i+1)-k)) {
                // 해당 값을 배치하고,
                ret[i] = (i + 1) - k;
                // Set에서 제거한다.
                numbers.remove((i+1)-k);
            }
            // 해당 숫자에서 k를 더한 값이 Set에 있으면,
            else if (numbers.contains((i+1)+k)) {
                // 해당 값을 배치하고,
                ret[i] = (i + 1) + k;
                // Set에서 제거한다.
                numbers.remove((i+1)+k);
            }
            // 더하거나 뺀 값이 Set에 없으면,
            else {
                // 재배치가 불가능하다.
                return new int[]{-1};
            }
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] result = absolutePermutation(n, k);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
