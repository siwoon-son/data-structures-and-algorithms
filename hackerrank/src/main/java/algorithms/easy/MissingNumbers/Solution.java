package algorithms.easy.MissingNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
        // arr에는 일부가 유실된 숫자들이, brr에는 원본이 저장되어 있다.
        // 유실된 숫자들을 중복없이 오름차순으로 반환한다.
        // (단, brr의 최대값과 최소값 차이는 100이다.)
        // 최대 100개의 숫자들의 빈도수를 저장할 배열을 생성하고,
        // brr의 빈도수로부터 arr의 빈도수를 빼서,
        // 빈도수에 남은 숫자들을 반환하자.

        // brr에서 가장 작은 값을 가져온다.
        int min = Integer.MAX_VALUE;
        for (int num: brr) {
            min = Math.min(min, num);
        }

        // 100개의 정수로 구성된 배열을 생성하고,
        int[] freqs = new int[100];
        // brr에 포함된 숫자들의 빈도수를 더한 후,
        for (int num: brr) {
            freqs[num-min]++;
        }
        // arr에 포함된 숫자들의 빈도수를 뺀다.
        for (int num: arr) {
            freqs[num-min]--;
        }

        // 유실된 숫자들을 중복없이 오름차순으로 리스트에 추가한다.
        List<Integer> missed = new ArrayList<>();
        for (int i=0; i<freqs.length; i++) {
            if (freqs[i] == 0) continue;
            missed.add(i + min);
        }

        // 리스트를 배열로 변환하여 반환한다.
        int[] ret = new int[missed.size()];
        for (int i=0; i<missed.size(); i++) {
            ret[i] = missed.get(i);
        }
        return ret;
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

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] brr = new int[m];

        String[] brrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int brrItem = Integer.parseInt(brrItems[i]);
            brr[i] = brrItem;
        }

        int[] result = missingNumbers(arr, brr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
