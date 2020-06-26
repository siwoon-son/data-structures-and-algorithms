package hackerrank.algorithms.easy.TimeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        // 12시 기준 시간을 시/분/초/오전오후로 구분하는 regex 생성
        // 시/분/초의 input format이 유효한 범위이므로 유효성 검사 없이 숫자 2개로 구분
        // 콜론을 기준으로 세 개의 숫자를 구분하고 마지막에 AM 또는 PM을 구분
        // 시/분/초/오전오후를 각각 그룹핑
        final String CLOCK_FORMAT_12_HOUR = "^([0-9]{2})[:]([0-9]{2})[:]([0-9]{2})(AM|PM)$";

        Pattern p = Pattern.compile(CLOCK_FORMAT_12_HOUR);
        Matcher m = p.matcher(s);

        StringBuilder builder = new StringBuilder();
        if (m.find()) {
            // 첫 번째 그룹인 시(hour)를 정수로 파싱
            int hh = Integer.parseInt(m.group(1));
            // 오전일 경우,
            if (m.group(4).equals("AM")) {
                // 00시부터 09시도 두 자리로 나타내기 위해 %02d 사용
                // 12시도 유효한 범위이며 이를 00시로 변환하기 위해 12의 나머지 연산
                builder.append(String.format("%02d", hh % 12));
            }
            // 오후일 경우,
            else {
                // 00시부터 09시도 두 자리로 나타내기 위해 %02d 사용
                // 12시도 유효한 범위이며 이를 00시로 변환하기 위해 12의 나머지 연산
                // 오후 00~11시를 12~23시로 변환하기 위해 12의 덧셈 연산
                builder.append(String.format("%02d", (hh % 12) + 12));
            }
            // 분(min)과 초(sec)도 콜론으로 구분하여 추가
            builder.append(":").append(m.group(2));
            builder.append(":").append(m.group(3));
        }
        return builder.toString();
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scan.nextLine();

        String result = timeConversion(s);

        System.out.println(result);
    }
}
