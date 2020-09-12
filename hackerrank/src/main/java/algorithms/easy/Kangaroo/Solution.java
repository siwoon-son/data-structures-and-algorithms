package algorithms.easy.Kangaroo;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Kangaroo_1은 x1에서 v1의 속도로 점프하므로 t초 후의 위치는 s_t = x1 + v1 * t이다.
        // Kangaroo_2는 x2에서 v2의 속도로 점프하므로 t초 후의 위치는 s_t = x2 + v2 * t이다.
        // 두 캥거루가 만나는 것은 같은 위치이므로, x1 + v1 * t = x2 + v2 * t이다.
        // 따라서, 두 캥거루가 만나는 시간은 t = (x1 - x2) / (v2 - v1)이다.
        double t = (double) (x1 - x2) / (v2 - v1);
        // 캥거루는 이산적으로 점프하므로 1의 나머지가 0이 아니면 점프 중에 만난 것이므로 나머지가 0일 때만 YES
        // 또는 음의 시간에서 만났을 수도 있으므로 양수일 때만 YES
        return (t % 1 == 0 && t > 0) ? "YES" : "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] x1V1X2V2 = scanner.nextLine().split(" ");

        int x1 = Integer.parseInt(x1V1X2V2[0]);

        int v1 = Integer.parseInt(x1V1X2V2[1]);

        int x2 = Integer.parseInt(x1V1X2V2[2]);

        int v2 = Integer.parseInt(x1V1X2V2[3]);

        String result = kangaroo(x1, v1, x2, v2);

        System.out.println(result);

        scanner.close();
    }
}
