package hackerrank.java.easy.JavaSubarray;

import java.util.*;

// https://www.hackerrank.com/challenges/java-negative-subarray/problem
public class JavaSubarray {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = scanner.nextInt();
        
        int countNeg = 0;
        for (int i=1; i<=n; i++) {
            for (int j=0; j<n-i+1; j++) {
                int sum = 0;
                for (int k=j; k<j+i; k++) {
                    sum += arr[k];
                }
                if (sum < 0) countNeg++;
            }
        }
        System.out.println(countNeg);

    }
}
