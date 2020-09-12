package algorithms.easy.CatsAndAMouse;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the catAndMouse function below.
    static String catAndMouse(int x, int y, int z) {
        // x 위치의 Cat A와 y 위치의 Cat B 중에서 어떤 Cat이 z 위치의 Mouse C에 먼저 도달할까?
        // A와 C의 거리를 계산한다.
        int distanceBetweenAandC = Math.abs(x-z);
        // B와 C의 거리를 계산한다.
        int distanceBetweenBandC = Math.abs(y-z);

        // 거리에 따라 가까운 Cat을 출력한다.
        if (distanceBetweenAandC < distanceBetweenBandC)
            return "Cat A";
        else if (distanceBetweenAandC > distanceBetweenBandC)
            return "Cat B";
        // 거리가 같으면 Mouse C는 도망간다.
        else
            return "Mouse C";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            System.out.println(result);
        }

        scanner.close();
    }
}
