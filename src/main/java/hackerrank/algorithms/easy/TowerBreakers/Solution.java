package hackerrank.algorithms.easy.TowerBreakers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the towerBreakers function below.
    static int towerBreakers(int n, int m) {
        // 높이가 m인 타워가 n개 있을 때,
        // 플레이어는 어떤 타워를 m이 정확히 나뉘는 수의 높이로 만들 수 있다.
        // 상대방을 더 이상 이동시킬 수 없을 때 승리한다면,
        // 주어진 n과 m에 대해, 승리자를 판단한다.

        // 패턴에 따라, 높이가 1이면,
        // 첫 번째 플레이어는 아무것도 할 수 없어서 패배한다.
        if (m == 1) return 2;
        // 타워의 수가 짝수면, 두 번째 플레이어는 첫 번째 플레이어를 따라하기만 하면 이긴다.
        // 타워의 수가 홀수면, 첫 번째 플레이어가 타워 하나의 높이를 1로 만들고,
        // 짝수의 경우처럼 게임하면 이긴다.
        return n % 2 == 1 ? 1 : 2;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int result = towerBreakers(n, m);

            System.out.println(String.valueOf(result));
        }

        scanner.close();
    }
}
