package algorithms.easy.JumpingOnTheClouds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        // Array c의 처음부터 끝까지 점프한 최소 횟수를 계산한다.
        // 이때, 점프는 +1 또는 +2까지 가능하며, c[i]의 값이 1이면 갈 수 없다.
        // 정답은 항상 존재한다.
        // 반복 횟수를 저장할 count 변수를 0으로 초기화한다.
        int count = 0;
        // 0 위치 부터 Array의 끝까지 반복한다.
        for (int i=0; i<c.length;) {
            // +2를 점프하는 것이 best이므로, +2를 점프할 수 있는지 확인한다.
            if (i+2 < c.length && c[i+2] != 1) i+=2;
            // +2를 점프하는 것이 불가능하면, +1을 점프한다.
            else i+=1;
            // 점프했으니 count를 하나 증가시킨다.
            count ++;
        }

        // 마지막 인덱스에서 점프한 횟수는 제외시킨다.
        return count-1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
