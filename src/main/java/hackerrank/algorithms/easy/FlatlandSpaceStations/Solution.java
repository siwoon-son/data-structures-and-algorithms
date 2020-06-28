package hackerrank.algorithms.easy.FlatlandSpaceStations;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the flatlandSpaceStations function below.
    static int flatlandSpaceStations(int n, int[] c) {
        // 임의의 도시에서 가장 가까운 space station과의 거리 중 최대값을 계산한다.
        // 이를 위해, 모든 도시와 가장 가까운 space station 거리를 계산하고, 거리의 최대값을 반환한다.
        // n개의 도시를 array로 생성한다.
        int[] cities = new int[n];
        // 각 도시와 가장 가까운 space station의 거리를 정수 범위 최대값으로 초기화한다.
        for (int i=0; i<n; i++) {
            cities[i] = Integer.MAX_VALUE;
        }

        // 모든 space station 위치의 앞/뒤로 도시들의 거리를 저장한다.
        for (int station: c) {
            // space station의 뒷방향에 있는 도시에 거리를 저장한다.
            // backward
            for (int i=station; i>=0; i--) {
                // 단, 이미 도시가 가진 거리보다 작을 때에만 저장한다.
                if (cities[i] > station - i) {
                    cities[i] = station - i;
                } 
                // 기존 거리보다 크면 더 이상 진행하지 않는다.
                else break;
            }

            // space station의 앞방향에 있는 도시에 거리를 저장한다.
            // toward
            for (int i=station+1; i<cities.length; i++) {
                // 단, 이미 도시가 가진 거리보다 작을 때에만 저장한다.
                if (cities[i] > i - station) {
                    cities[i] = i - station;
                } 
                // 기존 거리보다 크면 더 이상 진행하지 않는다.
                else break;
            }
        }

        // 모든 도시 중에서 space station과 가장 먼 거리를 가져온다.
        int longest = 0;
        for (int city: cities) {
            if (longest < city)
                longest = city;
        }

        return longest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[] c = new int[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = flatlandSpaceStations(n, c);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
