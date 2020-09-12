package algorithms.medium.Pairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
        // arr의 원소들 중, 서로의 차이가 k인 pair의 수를 센다.
        // pair는 unique하다.

        // arr의 원소들을 Set에 저장한다.
        Set<Integer> numbers = new HashSet<>();
        for (int num: arr)
            numbers.add(num);

        // 차이가 k인 pair의 수를 센다.
        int count = 0;
        for (int num: arr) {
            // 현재 숫자보다 k가 큰 숫자가 Set에 있는 경우
            if (numbers.contains(num+k))
                count++;
            // 현재 숫자보다 k가 작은 숫자가 Set에 있는 경우
            if (numbers.contains(num-k))
                count++;

            // 현재 숫자를 확인했으면 Set에서 제거한다.
            // Unique를 보장한다.
            numbers.remove(num);
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
