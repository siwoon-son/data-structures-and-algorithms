package hackerrank.algorithms.easy.TheHurdleRace;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
        // k 높이를 넘을 수 있을 때, 모든 hurdle를 넘기 위해 필요한 potion 수를 반환한다.
        // height에서 가장 높은 hurdle의 높이를 가져온다.
        int max = 0;
        for (int h: height) {
            max = Math.max(h, max);
        }

        // 가장 높은 hurdle이 k보다 높으면 그 차이만큼 potion이 필요하다.
        // 가장 높은 hurdle이 k보다 낮으면 potion은 필요하지 않다.
        return max > k ? max - k : 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] height = new int[n];

        String[] heightItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int heightItem = Integer.parseInt(heightItems[i]);
            height[i] = heightItem;
        }

        int result = hurdleRace(k, height);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
