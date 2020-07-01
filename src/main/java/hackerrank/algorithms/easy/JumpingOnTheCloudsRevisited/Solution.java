package hackerrank.algorithms.easy.JumpingOnTheCloudsRevisited;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c, int k) {
        // c[i]에서 (i + k) % n만큼 이동하며, c[0]에 도달했을 때 energy를 반환한다.
        // 단, 0 위치에서 시작하며, 이동마다 energy가 1씩, c[i]가 1이면 energy가 추가로 2 감소한다.

        // energy를 100으로 초기화한다.
        int e = 100;
        // 현재 위치를 0으로 초기화한다.
        int cur = 0;
        // 구름의 수를 기록한다.
        int n = c.length;

        // 한 번은 이동해야 하므로 do-while을 사용한다.
        do {
            // k만큼 이동한다.
            cur = (cur + k) % n;
            // 이동했으니 e를 1 감소시킨다.
            e--;
            // 이동한 곳이 thunderhead이면 e를 추가로 2 감소시킨다.
            if (c[cur] == 1) e -= 2;
        } while (cur != 0); // 시작점에 도달할 때까지 반복한다.

        return e;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
