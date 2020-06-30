package hackerrank.algorithms.easy.PickingNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // 정렬되지 않은 List a에서 임의의 두 원소간의 차이가 1 이하인 List의 최대 길이를 반환한다.
        // 숫자들의 개수를 세고, 연속된 숫자들의 개수 합을 비교한다.
        // List a에 포함되는 숫자는 2부터 100까지 이므로, 최대 100개의 숫자를 저장할 Array를 생성한다.
        int[] nOfNumbers = new int[100+1];

        // List a를 순회하며, 숫자들의 개수를 센다.
        for (int i: a) {
            nOfNumbers[i] ++;
        }

        // 1부터 100까지, 두 개씩 묶어서 개수를 더하며 최대 개수를 뽑는다.
        int max = 0;
        for (int i=0; i<nOfNumbers.length-1; i++) {
            max = Math.max(max, nOfNumbers[i] + nOfNumbers[i+1]);
        }

        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
