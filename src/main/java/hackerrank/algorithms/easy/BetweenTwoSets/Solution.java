package hackerrank.algorithms.easy.BetweenTwoSets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        // List a의 모든 원소들의 공배수와 List b의 모든 원소들의 공약수간의 교집합을 계산한다.
        // 공배수들은 모든 원소들보다 크며, 공약수들은 모든 원소들보다 작다.
        // 따라서, List a의 가장 큰 원소부터 List b의 가장 작은 원소까지만 비교한다.
        // 문제에서 두 리스트는 정렬되어있다는 힌트가 없으므로, 각 리스트를 순회하며 최대값, 최소값을 가져온다.
        // (하지만, 테스트 케이스들은 정렬되어 있는지 a의 마지막 원소와 b의 첫 원소를 가져와도 통과한다.)
        int from = getMax(a);
        int to = getMin(b);
        // 집계를 위해 0으로 초기화한다.
        int count = 0;

        // List a의 최대값부터 List b의 최소값까지 i 인덱스를 증가시키며 비교를 반복한다.
        // 이때, 반복마다 i 인덱스는 List a의 최대값인 from을 증가시킨다.
        // 이는 1씩 증가시키는 것보다 반복횟수를 크게 감소시킨다.
        // List a와 List b의 인덱스로 사용할 j, k 변수는 반복마다 0으로 초기화한다.
        for (int i=from, j=0, k=0; i<=to; i+=from, j=0, k=0) {
            // List a에서 공배수를 찾는다.
            // 반복이 끝났을 때 j 인덱스가 List a의 길이와 동일하면 공배수다.
            while (j < a.size()) {
                // 원소 하나라도 나누어떨어지지 않으면 공배수가 아니다.
                if (i % a.get(j) != 0) break;
                j++;
            }
            // List b에서 공약수를 찾는다.
            // 반복이 끝났을 때 k 인덱스가 List b의 길이와 동일하면 공배수다.
            while (k < b.size()) {
                // 원소 하나라도 나누어떨어지지 않으면 공약수가 아니다.
                if (b.get(k) % i != 0) break;
                k++;
            }
            // j 인덱스와 k 인덱스가 각각 리스트의 길이와 같다면 유효한 숫자이므로 count를 증가시킨다.
            if (j == a.size() && k == b.size()) count++;
        }

        return count;
    }

    // Integer List에서 가장 작은 원소를 반환한다.
    private static int getMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        for (int i: list) {
            if (min > i) min = i;
        }
        return min;
    }

    // Integer List에서 가장 큰 원소를 반환한다.
    private static int getMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (int i: list) {
            if (max < i) max = i;
        }
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        String[] brrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> brr = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrTemp[i]);
            brr.add(brrItem);
        }

        int total = Result.getTotalX(arr, brr);

        System.out.println(String.valueOf(total));

        bufferedReader.close();
    }
}
