package hackerrank.datastructures.medium.FormingAMagicSquare;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    private static int[][][] answers = new int[][][] {
            {{8, 1, 6},
             {3, 5, 7},
             {4, 9, 2}},

            {{6, 1, 8},
             {7, 5, 3},
             {2, 9, 4}},

            {{4, 9, 2},
             {3, 5, 7},
             {8, 1, 6}},

            {{2, 9, 4},
             {7, 5, 3},
             {6, 1, 8}},

            {{8, 3, 4},
             {1, 5, 9},
             {6, 7, 2}},

            {{4, 3, 8},
             {9, 5, 1},
             {2, 7, 6}},

            {{6, 7, 2},
             {1, 5, 9},
             {8, 3, 4}},

            {{2, 7, 6},
             {9, 5, 1},
             {4, 3, 8}},
    };

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        // 3*3 matrix가 가로, 세로, 대각선의 합이 모두 같으면 magic square라 한다.
        // 주어진 matrix를 magic square로 만들기 위해,
        // 필요한 최소 비용을 계산한다.
        // 비용은 어떤 숫자를 바꾸기 전과 바꾼 후의 차이이다.

        // 3*3 matrix에서 magic square는 총 8개로 구성된다.
        // 이를 3차원 배열 answer로 미리 선언한 후,
        // 주어진 matrix와 정답들을 모두 비교하여 최소 차이를 반환한다.

        // 현재까지 최소 비용을 가장 큰 정수로 초기화한다.
        int min = Integer.MAX_VALUE;

        // 8개의 정답과 비교한다.
        for (int i=0; i<8; i++) {
            min = Math.min(min, diffMatrix(s, answers[i]));
        }

        return min;
    }

    private static int diffMatrix(int[][] s1, int[][] s2) {
        int diff = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                diff += Math.abs(s1[i][j] - s2[i][j]);
            }
        }
        return diff;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {
            String[] sRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int sItem = Integer.parseInt(sRowItems[j]);
                s[i][j] = sItem;
            }
        }

        int result = formingMagicSquare(s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
