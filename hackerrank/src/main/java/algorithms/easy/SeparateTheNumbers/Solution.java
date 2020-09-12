package algorithms.easy.SeparateTheNumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the separateNumbers function below.
    static void separateNumbers(String s) {
        // 문자열 s가 증가하는 숫자로 이루어지는지,
        // 맞다면 가장 작은 첫 번째 숫자를 출력한다.
        // 첫 번째 숫자를 1의 자리, 10의 자리, 100의 자리, ...로 증가하도록 0으로 초기화한다.
        long first = 0;
        // 적어도 2개 이상의 숫자로 구성될 수 있도록 첫 번째 숫자를 문자열의 절반까지만으로 가정한다.
        for (int i=0; i<s.length()/2; i++) {
            // 첫 번째 숫자를 자리수 하나씩 증가시키며 누적합한다.
            first = first * 10 + (s.charAt(i) - '0');
            // 다음 값을 첫 번째의 1 증가시킨 값으로 초기화한다.
            long expected = first + 1;
            // 첫 번째 다음부터 끝까지 증가하는 숫자인지 확인한다.
            for (int j=i+1; j<s.length();) {
                // 예상값의 자리수를 계산한다.
                int digit = (int) Math.log10(expected) + 1;
                // 현재값이 문자열을 벗어나면 증가하는 숫자가 아니므로 더 이상 비교하지 않는다.
                if (j+digit > s.length()) break;
                // 현재값을 가져온다.
                long current = Long.parseLong(s.substring(j, j+digit));
                // 현재값과 예상값이 다르면 증가하는 숫자가 아니므로 더 이상 비교하지 않는다.
                if (current != expected) break;

                // 끝까지 비교했다면,
                if (j+digit == s.length()) {
                    // 첫 번째 숫자를 출력하고 메서드를 종료한다.
                    System.out.println("YES " + first);
                    return;
                }
                // 끝까지 비교하지 않았으므로, 예상값을 증가시킨다.
                expected += 1;
                // 다음값을 자리수만큼 증가시킨다.
                j += digit;
            }
        }
        // 모든 반복이 끝나도 증가하는 숫자가 아니면 "NO"를 출력한다.
        System.out.println("NO");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            separateNumbers(s);
        }

        scanner.close();
    }
}
