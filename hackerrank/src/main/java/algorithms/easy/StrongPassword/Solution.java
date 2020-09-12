package algorithms.easy.StrongPassword;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // 비밀번호가 다음의 조건을 만족하도록 필요한 문자의 수를 반환한다.
        // (1) 비밀번호의 길이는 최소 6이다.
        // (2) 비밀번호는 숫자 하나를 반드시 포함한다.
        // (3) 비밀번호는 소문자 하나를 반드시 포함한다.
        // (4) 비밀번호는 대문자 하나를 반드시 포함한다.
        // (5) 비밀번호는 특수문자 하나를 반드시 포함한다.

        // 숫자, 소문자, 대문자, 특수문자의 유무를 판별할 변수를 선언한다.
        boolean existsDigits = false;
        boolean existsLower = false;
        boolean existsUpper = false;
        boolean existsSpecial = false;

        // 비밀번호를 훑어본다.
        for (char c: password.toCharArray()) {
            // 숫자인 경우
            if ('0' <= c && c <= '9') existsDigits = true;
            // 소문자인 경우
            else if ('a' <= c && c <= 'z') existsLower = true;
            // 대문자인 경우
            else if ('A' <= c && c <= 'Z') existsUpper = true;
            // 특수문자인 경우
            else existsSpecial = true;

            // (2)~(4)의 네 가지 조건을 만족하면 더 이상 훑지 않는다.
            if (existsDigits && existsLower && existsUpper && existsSpecial) break;
        }

        // (2)~(4)를 만족하지 않는 조건의 수를 계산한다.
        int requisite = (existsDigits ? 0 : 1) + (existsLower ? 0 : 1) +
                (existsUpper ? 0 : 1) + (existsSpecial ? 0 : 1);
        // (1) 조건과 비교하여 최소 수를 계산한다.
        return Math.max(requisite, 6 - password.length());
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        System.out.println(String.valueOf(answer));

        scanner.close();
    }
}
