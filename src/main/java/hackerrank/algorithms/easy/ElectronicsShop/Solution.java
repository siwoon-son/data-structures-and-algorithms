package hackerrank.algorithms.easy.ElectronicsShop;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        // keyboard 하나와 drive 하나의 가격의 합이 최대한 b와 가까운 값을 반환한다.
        // 만약, 가능한 조합이 없다면 -1을 반환한다.
        // 이를 위해, 최대값을 -1로 초기화한다.
        int max = -1;

        // keyboard를 순회한다.
        for (int k: keyboards) {
            // 이미 keyboard의 가격이 b 이상이면, 다음 keyboard로 넘어간다.
            if (k >= b) continue;
            // drive를 순회한다.
            for (int d: drives) {
                // keyboard 가격과 drive 가격의 합이 b를 초과하면 제외한다.
                if (k + d > b) continue;
                // 현재 가격과 기존 가격 중, 더 큰 값을 max에 저장한다.
                max = Math.max(k + d, max);
            }
        }

        // 가능한 조합이 없다면 max는 그대로 -1을 유지한다.
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(String.valueOf(moneySpent));

        scanner.close();
    }
}
