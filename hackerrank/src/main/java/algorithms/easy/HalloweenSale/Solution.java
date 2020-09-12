package algorithms.easy.HalloweenSale;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the howManyGames function below.
    static int howManyGames(int p, int d, int m, int s) {
        // p 가격의 게임이 구매할 때마다 d 가격만큼 할인하고 최소 m 가격 이상에 판매할 때,
        // s로 구매할 수 있는 게임 수를 반환한다.
        // 구매할 게임 수를 0으로 초기화한다.
        int nOfGames = 0;
        // 가진 돈이 p보다 많아야 구매할 수 있다.
        while (s >= p) {
            // 구매 수를 증가시킨다.
            nOfGames++;
            // 가진 돈을 p 가격만큼 차감한다.
            s -= p;
            // 가격을 d 가격만큼 할인한다.
            p -= d;
            // 최소 m 가격을 보장한다.
            if (p < m) p = m;
        }

        return nOfGames;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] pdms = scanner.nextLine().split(" ");

        int p = Integer.parseInt(pdms[0]);

        int d = Integer.parseInt(pdms[1]);

        int m = Integer.parseInt(pdms[2]);

        int s = Integer.parseInt(pdms[3]);

        int answer = howManyGames(p, d, m, s);

        System.out.println(String.valueOf(answer));

        scanner.close();
    }
}
