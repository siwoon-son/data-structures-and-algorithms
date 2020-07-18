package hackerrank.algorithms.easy.JimAndTheOrders;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        // orders[i]는 i-번째 고객의 주문 정보를 가지고 있다.
        // orders[i][0]은 주문 시간을, orders[i][1]은 준비 시간을 의미한다.
        // 이때, 버거를 받는 순서대로 고객의 id (즉, i)를 반환한다.

        // 기존 orders는 [주문 시간, 준비 시간]의 pair이지만,
        // 이를 [받는 시간, 고객 id]로 변환한다.
        for (int i=0; i<orders.length; i++) {
            orders[i][0] = orders[i][0] + orders[i][1];
            orders[i][1] = i + 1;
        }

        // 버거를 받는 시간의 순서대로 정렬한다.
        Arrays.sort(orders, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 정렬된 고객의 id를 가져온다.
        int[] served = new int[orders.length];
        for (int i=0; i<orders.length; i++) {
            served[i] = orders[i][1];
        }

        return served;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

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
