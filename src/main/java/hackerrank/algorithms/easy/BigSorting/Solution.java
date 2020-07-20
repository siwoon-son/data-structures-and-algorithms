package hackerrank.algorithms.easy.BigSorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {
        // ** 이 문제는 템플릿 소스코드를 그대로 사용할 경우 test case 6에서 timeout이 발생한다.
        // ** Scanner와 Sysout 대신, 반드시 BufferedReader와 BufferedWriter를 사용해라.
        // 입력된 Array unsorted를 그대로 정렬하면, 대량의 test case에서 timeout이 발생한다.
        // 정렬 비용을 줄이기 위해, HashMap으로 각 숫자의 빈도수를 계산한다.
        Map<String, Integer> count = new HashMap<>();
        for (String s: unsorted) {
            Integer c = count.get(s);
            // Map에 존재하지 않는 숫자는 0으로 초기화한다.
            if (c == null) {
                c = 0;
            }
            // 해당 숫자의 빈도수를 1 증가시킨다.
            count.put(s, ++c);
        }

        // Map의 keyset(즉, 중복이 제거된 숫자들)을 가져온다.
        List<String> keys = new ArrayList(count.keySet());
        // 숫자들을 오름차순으로 정렬한다.
        // 문자열의 길이가 다르면, 긴 문자열이 더 큰 숫자다.
        // 문자열의 길이가 같으면, 가장 큰 자리수부터 하나씩 비교한다.
        Collections.sort(keys, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) return o1.length() - o2.length();
                for (int i=0; i<o1.length(); i++) {
                    if (o1.charAt(i) > o2.charAt(i)) return 1;
                    if (o1.charAt(i) < o2.charAt(i)) return -1;
                }
                return 0;
            }
        });

        // 정렬 전의 숫자 개수와 동일한 배열을 생성한다.
        String[] sorted = new String[unsorted.length];
        // HashMap에서 각 숫자의 개수만큼 반복하여 배열을 채운다. 
        int i = 0;
        for (String key: keys) {
            int c = count.get(key);
            for (int j=0; j<c; j++) {
                sorted[i++] = key;
            }
        }

        return sorted;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] unsorted = new String[n];

        for (int i = 0; i < n; i++) {
            String unsortedItem = scanner.nextLine();
            unsorted[i] = unsortedItem;
        }

        String[] result = bigSorting(unsorted);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.println();
            }
        }

        System.out.println();

        scanner.close();
    }
}
