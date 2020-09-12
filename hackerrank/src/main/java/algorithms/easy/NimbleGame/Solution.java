package algorithms.easy.NimbleGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the nimbleGame function below.
    static String nimbleGame(int[] s) {
        // Nimble Game: i-번째 박스에는 s[i]개의 코인이 있다.
        // 두 명의 참가자는 각자 차례에 i-번째 박스로부터 j-번째 박스로
        // 정확히 1개의 코인을 옮길 수 있다. (j < i)
        // 마지막 코인을 첫 번째 박스로 옮긴 참가자가 승리한다.

        // 이 문제는 Nim Game으로 변형할 수 있다.
        // (1) 첫 번째 박스에 있는 s[0]개의 코인들은 승패에 영향을 미치지 않는다.
        // (2) 짝수 개의 코인이 있는 박스에서 꺼낸 코인은
        // 다음 참가자가 똑같이 행동하므로 승패에 영향을 미치지 않는다.
        // 즉, 홀수 개의 코인이 있는 박스만이 승패에 영향이 있다.
        // (3) 홀수 개를 가진 박스에서 1개를 꺼내면 결국 짝수가 남기 때문에,
        // 홀수가 몇개인지는 중요하지 않다.
        // (4) 코인을 홀수 개 가진 박스의 위치에 따라 승패가 달라진다.
        // 이 내용을 종합하면, "홀수 개를 가진 박스와 첫 번째 박스의 거리가 Nim Game의 pile과 같다."
        int p = 0;

        for (int i=0; i<s.length; i++) {
            if (s[i] % 2 == 1)
                p ^= i;
        }

        return p == 0 ? "Second" :  "First";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] s = new int[n];

            String[] sItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int sItem = Integer.parseInt(sItems[i]);
                s[i] = sItem;
            }

            String result = nimbleGame(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
