package algorithms.easy.BeautifulTriplets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulTriplets function below.
    static int beautifulTriplets(int d, int[] arr) {
        // i < j < k 일때, arr[j] - arr[i] = arr[k] - arr[j] = d이면, beautiful triplet이다.
        // 이러한 beautiful triplet의 수를 반환한다.
        // 개수를 저장할 변수를 0으로 초기화한다.
        int count = 0;
        // i를 0부터 길이-2까지 반복한다.
        for (int i = 0; i < arr.length-2; i++) {
            // j를 i+1부터 길이-1까지 반복한다. (i < j)
            for (int j = i+1; j < arr.length-1; j++) {
                // arr[j] - arr[i]가 d와 같지 않으면 더 이상 볼 필요가 없다.
                if (arr[j] - arr[i] != d) continue;
                // k를 j+1부터 길이만큼 반복한다. (j < k)
                for (int k = j+1; k < arr.length; k++) {
                    // arr[k] - arr[j]가 d와 같지 않으면 다음으로 넘어간다.
                    if (arr[k] - arr[j] != d) continue;
                    // 조건을 만족하므로 count를 증가시킨다.
                    count++;
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = beautifulTriplets(d, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
