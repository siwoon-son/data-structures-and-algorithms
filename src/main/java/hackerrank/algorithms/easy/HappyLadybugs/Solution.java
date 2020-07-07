package hackerrank.algorithms.easy.HappyLadybugs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the happyLadybugs function below.
    static String happyLadybugs(String b) {
        // 대문자(ladybug)와 언더바로 구성된 문자열 b는 대문자를 어떤 언더바의 자리로 옮길 수 있다.
        // 바로 옆 자리에 같은 대문자가 있으면 happy하다고 할 때, 주어진 문자열 b가 happy할 수 있는지 검사한다.
        // 이는 다음과 같은 케이스로 나뉜다.
        // Case 1. 어떤 대문자가 하나만 존재하면 happy할 수 없다. -> "NO"
        // Case 2. 모든 대문자가 두 개 이상씩 존재하면서, 언더바가 하나라도 있으면 happy할 수 있다. -> "YES"
        // Case 3. 이웃한 모든 대문자가 이미 happy하면, 해당 문자열은 happy하다. -> "YES"

        // 빠른 접근을 위해, 문자열을 문자의 배열로 변환한다.
        char[] ladybugs = b.toCharArray();
        // 대문자의 개수를 저장할 배열을 생성한다.
        int[] countLadybugs = new int[26];
        // 언더바가 있는지 검사한다.
        boolean existsEmpty = false;

        // 모든 문자를 순회하면서,
        for (int i=0; i<ladybugs.length; i++) {
            // 어떤 문자가 언더바면,
            if (ladybugs[i] == '_') {
                // 언더바가 있음을 기록한다.
                existsEmpty = true;
                continue;
            }
            // 해당 문자의 개수를 1 증가시킨다.
            countLadybugs[ladybugs[i] - 'A']++;
        }

        // 하나만 존재하는 문자가 있는지 검사한다.
        boolean existsOnlyOne = false;
        for (int count: countLadybugs) {
            if (count == 1) {
                existsOnlyOne = true;
                break;
            }
        }
        // 하나만 존재하는 문자가 있으면 happy할 수 없다. -> Case 1
        if (existsOnlyOne) return "NO";
        // 모든 문자가 2개 이상씩 존재하면서, 언더바가 있다면 happy할 수 있다. -> Case 2
        if (existsEmpty) return "YES";

        // 이웃하는 문자끼리 같은지 확인한다.
        for (int i=0; i<ladybugs.length; i++) {
            if (i > 0 && ladybugs[i-1] == ladybugs[i]) continue;
            if (i < ladybugs.length-1 && ladybugs[i] == ladybugs[i+1]) continue;
            // 언더바가 없는데 이웃하는 문자가 같지 않으면 happy할 수 없다. -> Case 3
            return "NO";
        }
        return "YES";

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int g = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int gItr = 0; gItr < g; gItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String b = scanner.nextLine();

            String result = happyLadybugs(b);

            System.out.println(result);
        }

        scanner.close();
    }
}
