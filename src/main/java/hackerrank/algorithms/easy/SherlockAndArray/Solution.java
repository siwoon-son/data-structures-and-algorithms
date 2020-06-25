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
        int leftSum = arr.get(0);
        int rightSum = arr.get(arr.size()-1);
        int leftIdx = 0;
        int rightIdx = arr.size()-1;

        while (leftIdx < rightIdx) {
            if (leftSum < rightSum) {
                leftIdx ++;
                leftSum += arr.get(leftIdx);
            } else {
                rightIdx --;
                rightSum += arr.get(rightIdx);
            }
        }

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
