package algorithms.easy.BeautifulDaysAtTheMovies;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        // i부터 j까지 숫자 중, 원래 숫자와 뒤집은 숫자의 차이가 k로 나뉘는 갯수를 반환한다.
        // 갯수를 저장할 변수를 초기화한다.
        int countBeautifulDays = 0;

        // i부터 j까지 반복한다.
        for (; i <= j; i++) {
            // i와 reversed i의 차이를 계산한다.
            int diff = Math.abs(i - reverseOfInteger(i));
            // k로 나뉘면 갯수를 증가시킨다.
            if (diff % k == 0) countBeautifulDays++;
        }

        return countBeautifulDays;
    }

    final static int reverseOfInteger(int original) {
        // 입력된 숫자 original를 reverse한다.
        // reversed 숫자를 0으로 초기화한다.
        int reversed = 0;

        // original 값이 0이 될 때까지 반복한다.
        while (original != 0) {
            // reversed의 10배와 original의 1의자리 숫자를 더한다.
            reversed = reversed * 10 + original % 10;
            // original의 1의자리를 버린다.
            original /= 10;
        }

        return reversed;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
