package algorithms.easy.SherlockAndTheBeast;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the decentNumber function below.
    static void decentNumber(int n) {
        // "555"와 "33333"으로 이루어진 n개의 문자를 출력한다.
        // 단, 가능한 "555"가 가장 많이 포함되어야 한다.

        // "33333"의 개수와 "555"의 개수를 0으로 초기화한다.
        int nOf3 = 0;
        int nOf5 = 0;

        // n이 0 이하가 될 때까지 반복한다.
        while (n > 0) {
            // 현재 n이 3의 배수면 "555"만으로 구성될 수 있다.
            if (n % 3 == 0) {
                // "555"의 수를 n / 3으로 할당한다.
                nOf5 = n / 3;
                // n을 0으로 대체한다.
                n = 0;
            }
            // 현재 n이 3의 배수가 아니면,
            else {
                // "33333"을 하나 증가시킨다.
                nOf3 ++;
                // 문자의 수를 5 감소시킨다.
                n = n - 5;
            }
        }

        // 반복 후에 n이 음수면 "555"와 "33333"으로 구성할 수 없는 수다.
        if (n < 0) {
            System.out.println(-1);
            return;
        }

        // "555"와 "33333"의 문자열을 생성하고 출력한다.
        StringBuilder decentNumber = new StringBuilder();
        while (nOf5-- > 0) {
            decentNumber.append("555");
        }
        while (nOf3-- > 0) {
            decentNumber.append("33333");
        }
        System.out.println(decentNumber.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            decentNumber(n);
        }

        bufferedReader.close();
    }
}
