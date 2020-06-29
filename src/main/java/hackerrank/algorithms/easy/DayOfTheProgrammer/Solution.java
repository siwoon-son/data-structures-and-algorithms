package hackerrank.algorithms.easy.DayOfTheProgrammer;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        // 1700년부터 1917년까지 Julian 달력을, 1919년부터 2700년까지 Gregorian 달력을 사용한다.
        // Julian 달력의 윤년는 4로 나뉘는 경우를,
        // Gregorian 달력은 400으로 나뉘거나 4로 나뉘면서 100으로 나뉘지 않는 경우를 의미한다.
        // 전환기인 1918년에는 2월이 14일부터 시작한다.
        // 이 함수는 입력된 연도의 Day of Programmer인 256번째 날짜를 출력한다.

        // 1918년일 경우 256번째 날짜를 출력한다.
        if (year == 1918) return "26.09.1918";

        // 입력된 연도에 따라 Julian 달력과 Gregorian 달력의 윤년을 확인한다.
        boolean isLeapYear = false;
        if (year < 1917) {
            isLeapYear = year % 4 == 0;
        } else {
            isLeapYear = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        }

        // 윤년이면 9월 12일을 출력한다.
        if (isLeapYear) return "12.09." + year;
        // 윤년이 아니면 9월 13일을 출력한다.
        else return "13.09." + year;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        System.out.println(result);

        bufferedReader.close();
    }
}
