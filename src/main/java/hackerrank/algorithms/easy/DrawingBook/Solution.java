package hackerrank.algorithms.easy.DrawingBook;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        // {0, 1}, {2, 3}, ... 형태로 주어진 책에서
        // p 페이지까지 앞 또는 뒤로부터 최소로 넘기는 횟수를 계산한다.
        // 한 번에 두 페이지씩 넘어가므로, 2로 나누어 넘기는 횟수를 계산한다.
        // 앞에서 넘기는 횟수는 2의 몫으로 계산한다.
        int forward = p / 2;
        // 뒤에서 넘기는 횟수는 끝 페이지와 p 페이지의 차이를 2로 나눈 몫으로 계산한다.
        // 이때, 마지막 페이지가 짝수인지 홀수인지에 따라 결과가 달라질 수 있다.
        // 따라서, n 페이지가 짝수면 그대로, 홀수면 n+1 페이지로 바꾼다.
        // 이를 위해, n/2*2+1의 계산을 추가한다.
        int backward = ((n/2*2+1) - p) / 2;
        // 앞에서 넘기는 횟수와 뒤에서 넘기는 횟수의 최소를 반환한다.
        return Math.min(forward, backward);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = pageCount(n, p);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
