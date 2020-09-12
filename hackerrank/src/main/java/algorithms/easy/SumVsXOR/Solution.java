package algorithms.easy.SumVsXOR;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sumXor function below.
    static long sumXor(long n) {
        // 0 <= x <= n에 대해,
        // n + x = n xor x를 만족하는 x의 수를 계산한다.

        // 조건을 만족하려면, x는 n와 같은 자리의 비트가 1이어서는 안된다.
        // e.g. n = 1001이면, x는 0110은 가능하지만 0001은 불가능하다.

        // 이는 n에서 0 비트의 개수를 찾고, 그 비트 수로 만들 수 있는 숫자들(즉, 2^비트 수)을 계산한다.

        long countSumXor = 1;

        while (n > 0) {
            // n의 가장 오른쪽 비트가 0이면,
            if ((n & 1) == 0)
                // 가능한 x의 수를 2배 증가시킨다.
                countSumXor *= 2;
            // n의 비트를 한자리 옮긴다. 즉, 오른쪽 비트를 버린다.
            n >>= 1;
        }

        return countSumXor;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = sumXor(n);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
