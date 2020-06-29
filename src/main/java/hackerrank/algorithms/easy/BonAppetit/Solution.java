package hackerrank.algorithms.easy.BonAppetit;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        // bill에서 k 번째를 제외한 나머지의 합을 2로 나누고,
        // b와의 차액을 돌려줘야 한다.

        // k 번째를 제외한 모든 price의 합을 계산한다.
        int sum = 0;
        for (int i=0; i<bill.size(); i++) {
            if (k == i) continue;
            sum += bill.get(i);
        }

        // 차액을 계산한다.
        int diff = b - sum/2;
        // 차액이 없으면 Bon Appetit을 출력한다.
        if (diff == 0) System.out.println("Bon Appetit");
        // 차액이 있으면 차액을 출력한다.
        else System.out.println(diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nk = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] billItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> bill = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int billItem = Integer.parseInt(billItems[i]);
            bill.add(billItem);
        }

        int b = Integer.parseInt(bufferedReader.readLine().trim());

        bonAppetit(bill, k, b);

        bufferedReader.close();
    }
}
