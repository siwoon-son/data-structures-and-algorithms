package hackerrank.algorithms.easy.TaumAndBDay;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        // bc 가격의 까만 선물 b개와 wc 가격의 하얀 선물 w개를 사야한다.
        // 이때, 까만 선물과 하얀 선물은 서로 z 가격을 내면 교체할 수 있다.
        // 까만 선물 b개와 하얀 선물 w개를 사는 최소 금액을 반환한다.

        // 까만 선물의 가격이 하얀 선물을 구매 후 교체하는 비용보다 비싸면,
        if (bc > wc + z) {
            // 하얀 선물 가격으로 모든 선물을 구매하고, 교체 비용을 추가한다.
            return (long) (b + w) * wc + (long) b * z;
        }
        // 하얀 선물의 가격이 까만 선물을 구매 후 교체하는 비용보다 비싸면,
        else if (wc > bc + z) {
            // 까만 선물 가격으로 모든 선물을 구매하고, 교체 비용을 추가한다.
            return (long) (b + w) * bc + (long) w * z;
        }
        // 교체 비용을 추가하는 것이 더 비싸면,
        else {
            // 까만 선물과 하얀 선물을 각각의 가격으로 구매한다.
            return (long) b * bc + (long) w * wc;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int b = Integer.parseInt(firstMultipleInput[0]);

            int w = Integer.parseInt(firstMultipleInput[1]);

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int bc = Integer.parseInt(secondMultipleInput[0]);

            int wc = Integer.parseInt(secondMultipleInput[1]);

            int z = Integer.parseInt(secondMultipleInput[2]);

            long result = Result.taumBday(b, w, bc, wc, z);

            System.out.println(String.valueOf(result));
        }

        bufferedReader.close();
    }
}
