package hackerrank.algorithms.easy.SequenceEquation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        // 1부터 n사이의 중복되지 않는 숫자들이 n개의 배열 p에 저장된다.
        // 이때, p(p(y)) = x를 만족하는 y값을 반환한다.
        // 예를 들어, p = [5, 2, 1, 3, 4]이면,
        // x = 1 = p[3] = p[p[4]]이므로, y[1] = 4이다.
        // x = 2 = p[2] = p[p[2]]이므로, y[2] = 2이다.
        // x = 3 = p[4] = p[p[5]]이므로, y[3] = 5이다.
        // x = 4 = p[5] = p[p[1]]이므로, y[4] = 1이다.
        // x = 5 = p[1] = p[p[3]]이므로, y[5] = 3이다.

        // 반대로, y[p[p[i]]] = i이다.

        // p와 동일한 길이의 배열 y 생성한다.
        int[] y = new int[p.length];

        // p의 모든 원소를 순회한다.
        for (int i=0; i<p.length; i++) {
            // 인덱스의 범위를 1~n에서 0~n-1으로 바꾼다.
            y[p[p[i]-1]-1] = i+1;
        }

        return y;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
