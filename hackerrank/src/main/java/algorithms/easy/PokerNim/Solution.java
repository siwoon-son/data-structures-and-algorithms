package algorithms.easy.PokerNim;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pokerNim function below.
    static String pokerNim(int k, int[] c) {
        // Poker Nim은 Nim Game (refer to IntroductionToNimGame)과 유사하지만,
        // Nim Game은 pile로부터 돌을 가져갈 수만 있으나,
        // Poker Nim은 pile마다 최대 k번까지 돌을 추가할 수 있다.

        // 돌을 추가하는 연산이라는 차이점이 있지만,
        // First가 돌을 추가하면 Second는 따라서 돌을 추가할 수 있으니,
        // 결국 Nim Game과 결과는 같다.
        // 따라서, Nim Game과 솔루션도 같다.
        int xor = 0;
        for (int nStone: c) {
            xor ^= nStone;
        }

        return xor > 0 ? "First" : "Second";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
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

            String result = pokerNim(k, c);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
