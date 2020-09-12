package algorithms.easy.AChessboardGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the chessboardGame function below.
    static String chessboardGame(int x, int y) {
        // 체스의 나이트처럼 이동하되, 왼쪽과 위쪽으로만 이동할 수 있다.
        // (x, y) 위치에서 First 선수와 Second 선수가 교대로 이동할 때,
        // 더 이상 이동할 수 없는 선수가 패배한다.
        // 주어진 (x, y) 좌표에 대해, 승자를 구분한다.

        // 처음에는 승패 좌표를 실제로 그려보고 규칙에 따라 재귀 함수를 구현하였으나,
        // 아래와 같은 더 효율적인 코드를 발견했다.
        // (단, 이 코드는 8*8 보드에서 (8, 8) 위치는 Second가 승리해야 맞다.)

        // x와 y를 4로 나눈 나머지가,
        x = x % 4;
        y = y % 4;
        // 0 또는 3이면 First의 승리이다.
        return ( (y == 0) || (y == 3) || (x == 0) || (x == 3) ) ?
            "First" : "Second";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] xy = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xy[0]);

            int y = Integer.parseInt(xy[1]);

            String result = chessboardGame(x, y);

            System.out.println(result);
        }

        scanner.close();
    }
}
