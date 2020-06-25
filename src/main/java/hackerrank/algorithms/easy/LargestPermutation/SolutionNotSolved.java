package hackerrank.algorithms.easy.LargestPermutation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SolutionNotSolved {

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        int[] indexes = new int[arr.length+1];
        for (int i=0; i<arr.length; i++) {
            indexes[arr[i]] = i;
        }

        for (int i=arr.length; k-- > 0 && i > 0; i--) {
            if (indexes[i] == arr.length - i) continue;
            indexes[arr[arr.length-i]] = indexes[i];
            arr[indexes[i]] = arr[arr.length-i];
            arr[arr.length-i] = i;
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        scanner.close();
    }
}
