package algorithms.medium.TheTimeInWords;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // 숫자로 표현된 시간을 영문으로 변환한다.
    // 이때, (1) 정각은 o` clock
    // (2) 15분 또는 45분은 quarter
    // (3) 30분은 half
    // (4) 0 to 30분은 past, 그 이상은 to
    // (5) 1분은 1 minute로 표기한다.

    // 먼저 숫자를 문자로 변환해주는 배열을 생성한다.
    private static String[] numToWord = new String[] {
            "", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve",
            "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
            "eighteen", "nineteen", "twenty", "twenty one",
            "twenty two", "twenty three", "twenty four",
            "twenty five", "twenty six", "twenty seven",
            "twenty eight", "twenty nine", "half"
    };

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        // 정각인 경우
        if (m == 0)
            return numToWord[h] + " o' clock";
        // 1분이면 1 minute,
        // 0 to 30분이면, quarter 또는 half
        // 그 외에는 minutes를 사용한다.
        if (m <= 30)
            return numToWord[m] + (m != 15 && m != 30 ? (m == 1 ? " minute" : " minutes") : "") +
                    " past " + numToWord[h];
        // 30분을 넘어가면 남은 시간을 표기한다.
        return numToWord[60-m] + (m != 45 ? " minutes" : "") + " to " + numToWord[h+1];

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String result = timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
