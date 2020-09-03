package hackerrank.algorithms.medium.GamingArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String gamingArray(List<Integer> arr) {
        // Andy와 Bob은 교대로 배열에서 숫자를 제거하는 게임을 한다.
        // 각자의 턴에 배열의 최대값과 그 우측의 모든 값들을 제거한다.
        // 배열에 더이상 값이 없으면 패배한다.
        // Bob이 먼저 시작했을 때, 승자를 찾아라.

        // 승자는 arr[0]이 최대값일 때의 차례인 사람이다.
        // 최대값의 오른쪽은 의미 없는 숫자들이다.
        // 따라서, arr[0]이 최대값이 되는 차례를 찾아야 한다.
        // 이는 곧 배열의 왼쪽부터 순회하며, 최대값이 바뀌는 횟수이다.

        // 최대값과 최대값이 바뀌는 횟수를 0으로 초기화한다.
        int max = 0;
        int nOfSwitch = 0;

        // 배열의 모든 원소를 순회한다.
        for (int n: arr) {
            // 새로운 최대값이 발견되면,
            if (max < n) {
                // 최대값을 바꾸고 바뀐 횟수를 증가시킨다.
                max = n;
                nOfSwitch++;
            }
        }

        // 최대값이 바뀐 횟수가 짝수이면 Andy가, 홀수면 Bob이 승자이다.
        return nOfSwitch % 2 == 0 ? "ANDY" : "BOB";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < arrCount; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            String result = Result.gamingArray(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
