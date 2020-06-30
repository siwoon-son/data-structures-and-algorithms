package hackerrank.algorithms.easy.AngryProfessor;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
        // 학생들의 도착 시간인 Array a에서
        // 정시 이전에 도착한 학생 수가 threshold k보다 적으면 휴강(YES),
        // 정시 이전에 도착한 학생 수가 threshold k보다 많으면 강의를 한다(NO).

        // 학생들의 도착 시간을 순회한다.
        for (int arrivalTime: a) {
            // 도착 시간이 0보다 작거나 같으면(즉, 정시 이전에 도착하면),
            // k를 하나 줄이고,
            // k가 0에 도달하면 NO를 반환한다.
            if (arrivalTime <= 0 && --k == 0) {
                return "NO";
            }
        }
        // 모든 학생들의 도착 시간을 확인한 결과,
        // k보다 적은 학생이 정시에 도착했으면 YES를 반환한다.
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nk[0]);

            int k = Integer.parseInt(nk[1]);

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }

            String result = angryProfessor(k, a);

            System.out.println(result);
        }

        scanner.close();
    }
}
