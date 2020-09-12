package algorithms.medium.RecursiveDigitSum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superDigit function below.
    static int superDigit(String n, int k) {
        // 숫자 형태 문자열 n이 k번 반복된 수를 p라 할 때,
        // p가 하나의 digit이면, super digit이며,
        // p가 하나 이상의 digit이면, p는 모든 digit의 합이다.
        // 이때, p의 super digit을 계산하자.

        // 중요! superDigit(p) = superDigit(superDigit(n) * k)이다.

        // super digit을 0으로 초기화한다.
        int aSuperDigit = 0;

        // 숫자 n의 각 자리수를 반복하며 super digit에 더한다.
        // 이때, super digit이 두 자리가 되면, 자리수들을 합해서 super digit으로 만든다.
        for (char digit: n.toCharArray()) {
            aSuperDigit = superDigit(digit - '0', aSuperDigit);
        }

        // super digit * k의 super digit을 반환한다.
        return superDigit(0, aSuperDigit * k);
    }

    private static int superDigit(int digit, int sum) {
        // 합이 두 자리면 super digit이 아니므로, 자리수를 합하여 super digit이 될 때까지 반복한다.
        if (sum > 10) return superDigit(digit, sum/10 + sum%10);
        // 새로운 자리수를 합에 더한 후, super digit을 계산한다.
        if (digit > 0) return superDigit(0, sum + digit);
        // 현재 합이 super digit이면, 합을 반환한다.
        else return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        String n = nk[0];

        int k = Integer.parseInt(nk[1]);

        int result = superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
