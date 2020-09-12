package algorithms.medium.TheBombermanGame;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bomberMan function below.
    static String[] bomberMan(int n, String[] grid) {
        // '.'과 '0'으로 구성된 grid가 있다.
        // '.'은 empty, '0'은 bomb을 각각 의미한다.
        // bomb은 3초 뒤에 폭발하며, 하나의 bomb은 현재 cell과 주위 네 방향의 bomb을 제거한다. (연쇄 x)
        // bomber man은 1초 후부터 활동하며, 모든 빈 cell에 bomb을 설치하는 작업과 폭탄이 터지기를 지켜보는 작업을 번갈아한다.
        // 이때, n초 뒤의 grid 상태를 반환한다.

        // 이러한 패턴은 다음과 같이 정리된다.
        // [초기상태] [1초대기] [폭탄설치] [지켜보기]
        // [폭탄설치] [지켜보기] [폭탄설치] [지켜보기]
        // [폭탄설치] [지켜보기] [폭탄설치] [지켜보기]
        // ...
        // 이때, 2번째 줄부터는 똑같은 상태가 계속 반복된다.
        // 따라서, 초기와 1초를 제외한 나머지는 4개씩 묶어 반복된다. -> 즉, 최대 6번만 반복하여 패턴을 찾을 수 있다.

        // grid의 상태를 4가지로 구분하여 패턴을 추적한다.
        // String[] 타입을 가장 작고 빠르게 접근할 수 있는 2-d boolean 배열로 변환하자.
        boolean[][][] states = new boolean[4][grid.length][grid[0].length()];
        // 0초와 1초는 초기상태로 동일하다.
        states[0] = convertGridFromStrToBoolean(grid);
        states[1] = convertGridFromStrToBoolean(grid);

        // 현재는 1초이며, 반복마다 1초씩 증가한다.
        int sec = 1;
        // 최대 6초까지만 반복한다.
        while (++sec <= Math.min(n, 6)) {
            // 짝수 초에는 모든 cell에 bomb이 설치된다.
            if (sec % 2 == 0) {
                states[sec % 4] = allTrue2dBoolArray(grid.length, grid[0].length());
            }
            // 홀수 초에는 2초 전과 1초 전의 상태로부터 폭탄이 터진 나머지를 계산할 수 있다.
            else {
                states[sec % 4] = detonate(states[(sec-2) % 4], states[(sec-1) % 4]);
            }
        }

        // n을 4로 나눈 나머지를 최종 상태로 반환한다.
        // 2-d boolean array를 다시 String[]으로 변환한다.
        return convertGridFromBooleanToStr(states[n % 4]);
    }

    private static boolean[][] convertGridFromStrToBoolean(String[] grid) {
        boolean[][] boolGrid = new boolean[grid.length][grid[0].length()];

        for (int i=0; i<grid.length; i++) {
            char[] row = grid[i].toCharArray();
            for (int j=0; j<row.length; j++) {
                if (row[j] == 'O') boolGrid[i][j] = true;
            }
        }

        return boolGrid;
    }

    private static String[] convertGridFromBooleanToStr(boolean[][] grid) {
        String[] strGrid = new String[grid.length];

        for (int i=0; i<grid.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<grid[0].length; j++) {
                sb.append(grid[i][j] ? 'O' : '.');
            }
            strGrid[i] = sb.toString();
        }

        return strGrid;
    }

    private static boolean[][] allTrue2dBoolArray(int r, int c) {
        boolean[][] boolArray = new boolean[r][c];

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                boolArray[i][j] = true;
            }
        }

        return boolArray;
    }

    private static boolean[][] detonate(boolean[][] prev2sec, boolean[][] prev1sec) {
        int r = prev2sec.length;
        int c = prev2sec[0].length;
        boolean[][] grid = new boolean[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                grid[i][j] = prev1sec[i][j];
            }
        }

        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                if (!prev2sec[i][j]) continue;
                grid[i][j] = false;
                if (0 <= i-1) grid[i-1][j] = false;
                if (i+1 < r) grid[i+1][j] = false;
                if (0 <= j-1) grid[i][j-1] = false;
                if (j+1 < c) grid[i][j+1] = false;
            }
        }

        return grid;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] rcn = scanner.nextLine().split(" ");

        int r = Integer.parseInt(rcn[0]);

        int c = Integer.parseInt(rcn[1]);

        int n = Integer.parseInt(rcn[2]);

        String[] grid = new String[r];

        for (int i = 0; i < r; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] result = bomberMan(n, grid);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(result[i]);

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
