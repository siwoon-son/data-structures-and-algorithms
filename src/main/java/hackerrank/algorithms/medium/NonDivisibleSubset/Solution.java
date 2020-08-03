package hackerrank.algorithms.medium.NonDivisibleSubset;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // s의 부분집합 중, 두 원소의 합이 k로 나누어 떨어지지 않는 원소들로만 구성된 부분집합의 최대 길이를 반환한다.
        // 모든 두 원소의 합을 k로 나누는 방식은 비효율적이다.
        // 다음의 직관이 중요한 해결책이다.
        // (x + y) % z == ((x % z) + (y % z)) % z
        // 따라서, x != y 임에도 x % z == y % z이면, x와 y를 동일하게 취급한다.

        // 먼저, 모든 원소들로부터 k의 나머지 개수를 계산한다.
        int[] remainders = new int[k];
        for (int num: s) {
            remainders[num % k]++;
        }

        // 나머지가 0인 경우, 즉 나누어 떨어지는 원소들은 서로 합해도 k에 의해 나누어 떨어지므로 1개만 사용할 수 있다.
        int nOfNonDivisible = Math.min(remainders[0], 1);
        // k가 짝수인 경우에 한해, k/2로 나누어 떨어지는 원소들은 서로 합해도 k/2에 의해 나누어 떨어지므로 1개만 사용할 수 있다.
        if (k % 2 == 0)
            remainders[k/2] = Math.min(remainders[k/2], 1);
        // 나머지가 i인 원소와 k-i인 원소를 합하면 나누어 떨어지므로, 둘 중 더 많은 원소를 갯수에 포함시킨다.
        for (int i=1; i<=k/2; i++) {
            nOfNonDivisible += Math.max(remainders[i], remainders[k-i]);
        }

        return nOfNonDivisible;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sTemp[i]);
            s.add(sItem);
        }

        int result = Result.nonDivisibleSubset(k, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
