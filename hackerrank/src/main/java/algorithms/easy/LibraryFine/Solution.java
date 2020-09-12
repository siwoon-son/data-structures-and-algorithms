package algorithms.easy.LibraryFine;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the libraryFine function below.
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        // 반납일이 예상일보다 늦으면 벌금을 청구한다.
        // 연도가 달라지면 벌금은 10,000 Hackos다.
        if (y1 > y2) return 10000;
        // 월이 달라지면 벌금은 500 * 월수 Hackos다.
        if (y1 == y2 && m1 > m2) return 500 * (m1-m2);
        // 일이 달라지면 벌금은 15 * 일수 Hackos다.
        if (y1 == y2 && m1 == m2 && d1 > d2) return 15 * (d1-d2);
        // 일찍 반납하면 벌금이 없다.
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] d1M1Y1 = scanner.nextLine().split(" ");

        int d1 = Integer.parseInt(d1M1Y1[0]);

        int m1 = Integer.parseInt(d1M1Y1[1]);

        int y1 = Integer.parseInt(d1M1Y1[2]);

        String[] d2M2Y2 = scanner.nextLine().split(" ");

        int d2 = Integer.parseInt(d2M2Y2[0]);

        int m2 = Integer.parseInt(d2M2Y2[1]);

        int y2 = Integer.parseInt(d2M2Y2[2]);

        int result = libraryFine(d1, m1, y1, d2, m2, y2);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
