package hackerrank.algorithms.easy.SherlockAndArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the balancedSums function below.
    static String balancedSums(List<Integer> arr) {
        // List arr에서 특정 원소를 기준으로 
        // 왼쪽 원소들의 합과 오른쪽 원소들의 합이 같으면 YES,
        // 그러한 원소가 없으면 NO를 반환한다.

        // 왼쪽 합을 첫 번째 원소로 초기화한다.
        int leftSum = arr.get(0);
        // 오른쪽 합을 마지막 원소로 초기화한다.
        int rightSum = arr.get(arr.size()-1);
        // 왼쪽 인덱스를 0으로 초기화한다.
        int leftIdx = 0;
        // 오른쪽 인덱스를 마지막 위치로 초기화한다.
        int rightIdx = arr.size()-1;

        // 왼쪽, 오른쪽 인덱스를 비교하며 반복한다.
        while (leftIdx < rightIdx) {
            // 왼쪽 합보다 오른쪽 합이 더 크면,
            if (leftSum < rightSum) {
                // 왼쪽 인덱스를 증가시키고,
                leftIdx ++;
                // 왼쪽 합에 해당 원소를 더한다.
                leftSum += arr.get(leftIdx);
            } 
            // 오른쪽 합보다 왼쪽 합이 더 크면,
            else {
                // 오른쪽 인덱스를 감소시키고,
                rightIdx --;
                // 오른쪽 합에 해당 원소를 더한다.
                rightSum += arr.get(rightIdx);
            }
        }

        // 반복 후에 왼쪽 합과 오른쪽 합이 같으면 YES, 다르면 NO를 반환한다.
        return leftSum == rightSum ? "YES" : "NO";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr.add(arrItem);
            }

            String result = balancedSums(arr);

            System.out.println(result);
        }

        bufferedReader.close();
    }
}
