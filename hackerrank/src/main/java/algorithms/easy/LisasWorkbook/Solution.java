package algorithms.easy.LisasWorkbook;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the workbook function below.
    static int workbook(int n, int k, int[] arr) {
        // 한 페이지당 최대 k개의 문제를 가지며, arr에 챕터별 문제 수가 저장되어 있다.
        // 만약, 문제 번호와 페이지 번호가 같다면, 그 문제는 special하다.
        // special한 문제의 수를 반환한다.
        // 현재 페이지를 1로 초기화한다.
        int currPage = 1;
        // special한 문제의 수를 0으로 초기화한다.
        int countSpecial = 0;
        // 챕터별 문제를 가져오기 위해 arr를 순회한다.
        // 단, 실제로는 1부터지만 0-index라 가정한다.
        for (int chapter = 0; chapter<arr.length; chapter++) {
            // 어떤 챕터의 문제 수를 가져온다.
            int nOfProblems = arr[chapter];
            // 문제 수만큼 반복하되, 페이지당 최대 k개의 문제를 가지므로 k만큼 증가시킨다.
            for (int problem = 1; problem <= nOfProblems; problem+=k) {
                // 특정 페이지의 첫 문제와 마지막 문제 사이에 해당 페이지 번호가 있다면,
                if (problem <= currPage && currPage <= Math.min(nOfProblems, problem + k - 1)) {
                    // special한 문제의 수를 증가시킨다.
                    countSpecial++;
                }
                // 페이지를 한장 넘긴다.
                currPage++;
            }
        }

        return countSpecial;
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

        int result = workbook(n, k, arr);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
