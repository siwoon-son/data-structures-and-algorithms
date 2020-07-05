package hackerrank.algorithms.easy.ServiceLane;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the serviceLane function below.
    static int[] serviceLane(int n, int width[], int[][] cases) {
        // cases[i][0]부터 cases[i][1] 범위의 index 중, width의 가장 작은 값을 i마다 계산하여 반환한다.
        // cases 수만큼 Array를 생성한다.
        int[] smallest = new int[cases.length];
        for (int aCase=0; aCase<cases.length; aCase++) {
            // cases[i][0]의 width를 최소값이라 가정한다.
            int min = width[cases[aCase][0]];
            // cases[i][1]까지 최소값을 찾는다.
            for (int i=cases[aCase][0]+1; i<=cases[aCase][1]; i++) {
                if (width[i] < min)
                    min = width[i];
            }
            // Array에 최소값을 넣는다.
            smallest[aCase] = min;
        }

        return smallest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nt = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nt[0]);

        int t = Integer.parseInt(nt[1]);

        int[] width = new int[n];

        String[] widthItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int widthItem = Integer.parseInt(widthItems[i]);
            width[i] = widthItem;
        }

        int[][] cases = new int[t][2];

        for (int i = 0; i < t; i++) {
            String[] casesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int casesItem = Integer.parseInt(casesRowItems[j]);
                cases[i][j] = casesItem;
            }
        }

        int[] result = serviceLane(n, width, cases);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
