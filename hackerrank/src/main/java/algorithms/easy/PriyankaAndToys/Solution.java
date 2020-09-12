package algorithms.easy.PriyankaAndToys;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the toys function below.
    static int toys(int[] w) {
        // 컨테이너에 적재될 모든 장난감은 가장 적은 무게의 +4 보다 작거나 같아야 한다.
        // 이때, 최소 컨테이너 수를 반환한다.

        // 먼저 모든 무게들을 오름차순으로 정렬한다.
        Arrays.sort(w);

        // 첫 번째 장난감을 컨테이너에 적재한다고 가정한다.
        int nOfContainers = 1;
        int currentMinWeight = w[0];
        // 두 번째 장난감부터,
        for (int i=1; i<w.length; i++) {
            // 장난감이 현재 컨테이너에 적재될 수 없다면,
            if (w[i] > currentMinWeight+4) {
                // 새로운 컨테이너를 추가하고,
                nOfContainers++;
                // 새로운 컨테이너의 최소 무게를 변경한다.
                currentMinWeight = w[i];
            }
        }

        return nOfContainers;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] w = new int[n];

        String[] wItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int wItem = Integer.parseInt(wItems[i]);
            w[i] = wItem;
        }

        int result = toys(w);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
