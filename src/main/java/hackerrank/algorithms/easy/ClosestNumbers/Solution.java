package hackerrank.algorithms.easy.ClosestNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
        // 주어진 배열에서 원소간의 차이가 가장 적은 쌍들을 정렬된 상태로 모두 반환한다.
        // n개의 원소들을 두 개씩 바로 비교하면 O(n^2)의 연산이 발생하므로,
        // 복잡도를 조금이라도 줄이기 위해 우선 정렬한다.
        Arrays.sort(arr);

        // 차이가 가장 적은 쌍들을 저장할 리스트를 생성한다.
        // 몇 개의 쌍이 나타날지 모르니 배열보다 리스트가 더 적합하다.
        List<Integer> pairs = new ArrayList<Integer>();
        // 현재까지 가장 낮은 차이를 초기화한다.
        int minDiff = Integer.MAX_VALUE;
        // 정렬된 배열을 순회한다.
        for (int i=0; i<arr.length-1; i++) {
            // 연속된 두 원소의 차이를 계산한다.
            int diff = Math.abs(arr[i] - arr[i+1]);
            // 현재의 차이가 기존 최소값보다 작으면,
            if (diff < minDiff) {
                // 최소값을 갱신하고,
                minDiff = diff;
                // 리스트를 초기화하고,
                pairs.clear();
                // 쌍을 리스트에 저장한다.
                pairs.add(arr[i]);
                pairs.add(arr[i+1]);
            }
            // 현재의 차이가 기존 최소값과 같으면,
            else if (diff == minDiff){
                // 쌍을 리스트에 저장한다.
                pairs.add(arr[i]);
                pairs.add(arr[i+1]);
            }
        }

        // 반환형에 맞게 리스트를 배열로 변경한다.
        int[] ret = new int[pairs.size()];
        for (int i=0; i<pairs.size(); i++) {
            ret[i] = pairs.get(i);
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

        int[] result = closestNumbers(arr);

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
