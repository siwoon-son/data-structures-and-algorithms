package algorithms.easy.IntroductionToNimGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the nimGame function below.
    static String nimGame(int[] pile) {
        // Nim Game: 각 pile마다 pile[i]개의 돌들이 있고,
        // 자기 차례에 하나의 pile로부터 하나 이상의 돌을 가져갈 수 있다.
        // First와 Second 중 누가 이길 것인가?

        // 이 문제의 솔루션은 이해하기 어려우나 매우 간단히 풀 수 있다.
        // 솔루션: pile[1] xor pile[1] xor ... xor pile[n]의 결과가
        // (1) 0보다 크면 First가 승리한다.
        // (2) 0이면 Second가 승리한다.
        int xor = 0;
        for (int nStone: pile) {
            xor ^= nStone;
        }

        return xor > 0 ? "First" : "Second";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] pile = new int[n];

            String[] pileItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int pileItem = Integer.parseInt(pileItems[i]);
                pile[i] = pileItem;
            }

            String result = nimGame(pile);

            System.out.println(result);
        }

        scanner.close();
    }
}
