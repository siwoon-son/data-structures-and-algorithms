package algorithms.easy.BeautifulBinaryString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulBinaryString function below.
    static int beautifulBinaryString(String b) {
        // 0과 1로 구성된 문자열 b가 "010"의 패턴을 갖지 않게 바꿔야할 최소 문자 수를 반환한다.
        // "010"의 패턴을 만나면 오른쪽 0을 1로 바꾼다고 가정한다.
        // 바꿔야할 문자 수를 0으로 초기화한다.
        int nOfChanged = 0;
        // 세번째부터 끝까지 반복한다.
        for (int i=2; i<b.length(); i++) {
            // i-2번째, i-1번째, i번째의 문자가 "010"이면,
            if (b.charAt(i-2) == '0' && b.charAt(i-1) == '1' && b.charAt(i) == '0') {
                // i번을 0으로 바꾼다고 가정하고, (실제로 바꾸진 않는다.)
                nOfChanged ++;
                // 010에서 011로 바꿨으니 그 다음 두 개는 확인할 필요가 없다.
                i += 2;
            }
        }

        return nOfChanged;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String b = scanner.nextLine();

        int result = beautifulBinaryString(b);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
