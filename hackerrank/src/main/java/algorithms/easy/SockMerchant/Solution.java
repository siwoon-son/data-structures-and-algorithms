package algorithms.easy.SockMerchant;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        // 양말 더미에서 pair의 개수를 센다.
        // 양말은 최대 100가지이므로, 양말을 모두 담을 수 있는 배열을 생성한다.
        // 공간 복잡도를 최소화하기 위해 boolean 타입을 사용한다.
        boolean[] socks = new boolean[100+1];
        int nPairs = 0;

        // 양말 더미에서 한 짝씩 가져온다.
        for (int sock: ar) {
            // 양말 한 짝을 발견하면 기존 boolean을 뒤집는다.
            socks[sock] = !socks[sock];
            // boolean을 뒤집었는데 false이면, 한 쌍이 완성된 것이다.
            if (!socks[sock])
                nPairs ++;
        }

        return nPairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
