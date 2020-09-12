package algorithms.easy.MarcsCakewalk;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the marcsCakewalk function below.
    static long marcsCakewalk(int[] calorie) {
        // Marc는 i-번째 케익을 먹으면,
        // 반드시 2^(i-1) * {i-번째 케익의 칼로리} miles 만큼 걸어야한다.
        // 다양한 칼로리의 케익을 먹은 후, 걸어야할 최소 miles을 반환한다.
        // 이는 곧 높은 칼로리 순으로 먼저 먹는 것이 최소 mile을 만드는 방법이다.

        // 우선 칼로리들을 정렬한다.
        Arrays.sort(calorie);

        // 최소 miles을 저장할 변수를 초기화한다.
        long miles = 0l;
        // 칼로리들을 순회한다.
        for (int i=0; i<calorie.length; i++) {
            // 오름차순으로 정렬되어 있으므로,
            // 내림차순으로 제곱하기 위해 지수를 {케익 개수 - i - 1}로 지정한다.
            miles += Math.pow(2, calorie.length-i-1) * calorie[i];
        }

        return miles;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] calorie = new int[n];

        String[] calorieItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int calorieItem = Integer.parseInt(calorieItems[i]);
            calorie[i] = calorieItem;
        }

        long result = marcsCakewalk(calorie);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
