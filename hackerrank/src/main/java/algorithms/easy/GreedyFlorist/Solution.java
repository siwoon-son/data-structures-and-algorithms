package algorithms.easy.GreedyFlorist;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getMinimumCost function below.
    // https://geehye.github.io/hackerrank-04/#
    static int getMinimumCost(int k, int[] c) {
        int[] friends = new int[k];
        for(int i = 0; i < k; i++) friends[i] = c.length / k;
        for(int i = 0; i < c.length % k; i++) friends[i] += 1;

        Arrays.sort(c);
        int sum = 0, idx = 0;
        while(idx < c.length) {
            for(int j = 0; j < k; j++) {
                if(friends[j] > 0) sum += (--friends[j] + 1) * c[idx++];
            }
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
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

        int minimumCost = getMinimumCost(k, c);

        System.out.println(String.valueOf(minimumCost));

        scanner.close();
    }
}
