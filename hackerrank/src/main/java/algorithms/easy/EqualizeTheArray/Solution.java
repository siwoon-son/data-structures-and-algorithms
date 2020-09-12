package algorithms.easy.EqualizeTheArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        // Array arr에서 똑같은 숫자만 남기기 위해, 지워야할 숫자의 최소 갯수를 반환한다.
        // 이는 곧 가장 많은 숫자를 제외한 나머지 숫자들의 갯수와 같다.
        // 숫자는 [1, 100]의 범위이므로, 이 숫자들의 갯수를 저장할 배열을 생성한다.
        int[] nOfNumbers = new int[100+1];

        // 숫자들의 갯수를 센다.
        for (int num: arr) {
            nOfNumbers[num]++;
        }

        // 지워야할 숫자의 갯수를 0으로 초기화한다.
        int countToBeRemoved = 0;
        // 현재까지 가장 많은 숫자 갯수를 0으로 초기화한다.
        int maxNum = 0;
        // [1, 100] 사이의 숫자들의 갯수를 순회한다.
        for (int i=1; i<nOfNumbers.length; i++) {
            // 만약, 새로운 숫자가 기존 숫자보다 더 많다면,
            if (nOfNumbers[i] > maxNum) {
                // 기존 숫자는 지워져야하며,
                countToBeRemoved += maxNum;
                // 새로운 숫자를 가장 많은 숫자로 대체한다.
                maxNum = nOfNumbers[i];
            }
            // 만약, 새로운 숫자가 기존 숫자보다 더 적다면,
            else {
                // 새로운 숫자는 지워져야 한다.
                countToBeRemoved += nOfNumbers[i];
            }
        }

        return countToBeRemoved;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = equalizeArray(arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
