package algorithms.easy.SuperReducedString;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        // 문자열 s에서 연속된 문자가 같은 두 문자를 제거한다.
        // 이러한 작업이 반복되었을 때 가장 짧은 문자열을 반환한다.
        // (단, 두 문자가 제거되었을 때, 연쇄적으로 연속된 문자가 같을 수 있음을 유의한다.)

        // 문자열은 update가 불가능하므로 StringBuilder로 변환한다.
        StringBuilder sb = new StringBuilder(s);

        // 문자열의 인덱스를 0부터 길이-1까지 반복한다.
        for (int i=0; i<sb.length()-1; i++) {
            // i번째와 i+1번째 문자가 같으면,
            if (sb.charAt(i) == sb.charAt(i+1)) {
                // 두 문자를 제거하고,
                sb.delete(i, i+2);
                // 인덱스를 2 감소시킨다. (두 문자가 제거되었기 때문에)
                // 인덱스가 음수 범위로 내려가지 않게 최소 -1까지만 감소시킨다.
                i = Math.max(i-2, -1);
            }
        }

        // 결과 문자열이 비어있다면 "Empty String"을 반환한다.
        if (sb.toString().equals("")) return "Empty String";
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
