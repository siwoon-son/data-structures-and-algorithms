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
        int[] cities = new int[n];
        for (int i=0; i<n; i++) {
            cities[i] = Integer.MAX_VALUE;
        }

        for (int station: c) {
            // backward
            for (int i=station; i>=0; i--) {
                if (cities[i] > station - i) {
                    cities[i] = station - i;
                } else break;
            }

            // toward
            for (int i=station+1; i<cities.length; i++) {
                if (cities[i] > i - station) {
                    cities[i] = i - station;
                } else break;
            }
        }

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
