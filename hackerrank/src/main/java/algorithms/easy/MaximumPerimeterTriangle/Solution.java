package algorithms.easy.MaximumPerimeterTriangle;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        // 삼각형 변의 길이들이 저장된 배열로부터
        // 가장 긴 둘레의 삼각형을 구성하는 변들(triple)을 반환한다.

        // 가장 간단한 방법은 N개의 원소를 갖는 배열로부터,
        // i-번째, j-번째, k-번째의 원소들, 즉 (i, j, k)로 삼각형을 구성하고,
        // 이들의 둘레 중 가장 큰 값을 계산하는 것이다.
        // 하지만, 이 방법은 O(N^3)의 높은 복잡도를 갖는다.

        // 이를 간단히 하여, 배열을 정렬하고,
        // 가장 큰 값부터 세 개씩 묶어 삼각형을 구성할 수 있다면,
        // 해당 triple이 정답이다.

        // 배열을 먼저 정렬한다.
        Arrays.sort(sticks);

        // 배열의 가장 끝부터,
        for (int i=sticks.length-1; i>=2; i--) {
            // 세 개씩 묶어서 가장 긴 변이 나머지 두 변의 합보다 작으면,
            if (sticks[i] < sticks[i-1] + sticks[i-2]) {
                // 삼각형이 가능하므로 triple을 반환한다.
                // 이보다 더 긴 둘레의 삼각형은 있을 수 없다.
                return new int[]{sticks[i-2], sticks[i-1], sticks[i]};
            }
        }

        // 반복 끝에도 삼각형이 없으면 null을 반환한다.
        return null;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        String[] sticksItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int sticksItem = Integer.parseInt(sticksItems[i]);
            sticks[i] = sticksItem;
        }

        int[] result = maximumPerimeterTriangle(sticks);

        // 예제 코드에는 없으나 null이 반환되면 -1을 출력한다.
        if (result == null) System.out.println("-1");
        else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
        }

        System.out.println();

        scanner.close();
    }
}
