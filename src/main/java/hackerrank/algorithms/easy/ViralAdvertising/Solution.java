package hackerrank.algorithms.easy.ViralAdvertising;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the viralAdvertising function below.
    static int viralAdvertising(int n) {
        // 첫날 5명에게 광고하고, 그 중 절반이 광고를 좋아하고, 그들은 각자 3명에게 전달한다.
        // 이때, n 번째 날에 광고를 좋아한 사람의 수를 반환한다.
        // 광고를 좋아한 사람의 수를 0으로 초기화한다.
        int cumulative = 0;

        // 1일부터 n일까지 반복한다.
        // shared를 5명으로 초기화한다.
        for (int i=1, shared=5; i<=n; i++) {
            // 절반의 사람이 광고를 좋아한다.
            int liked = shared/2;
            cumulative += liked;
            // 다음날 광고가 공유될 수를 3배 증가시킨다.
            shared = liked * 3;
        }

        return cumulative;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = viralAdvertising(n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
