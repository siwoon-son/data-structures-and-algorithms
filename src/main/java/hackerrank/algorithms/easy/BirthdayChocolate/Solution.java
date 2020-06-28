package hackerrank.algorithms.easy.BirthdayChocolate;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        // List s에서 sliding window m 마다 원소의 합이 d인 개수를 반환한다.
        // 개수를 저장할 count 변수와 sliding window의 원소 합을 저장할 sum 변수를 초기화한다.
        int count = 0, sum = 0;
        // sliding window의 원소를 저장할 Queue buffer를 생성한다.
        Queue<Integer> buffer = new LinkedList<Integer>();

        // List s를 순회한다.
        for (int i: s) {
            // List s의 초반에는 buffer가 가득차지 않는다.
            // 이전 반복에서 buffer의 개수가 m이면, (즉 sliding window가 가득차면,)
            if (buffer.size() == m) {
                // buffer에서 가장 오래된 원소를 제거하고, 누적합에서 뺀다.
                sum -= buffer.poll();
            }
            // buffer에 새로운 원소를 추가한다.
            buffer.add(i);
            // 추가된 원소를 누적합에 더한다.
            sum += i;

            // buffer가 가득차고 누적합이 d와 같으면 count를 증가시킨다.
            if (buffer.size() == m && sum == d) count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] sItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int sItem = Integer.parseInt(sItems[i]);
            s.add(sItem);
        }

        String[] dm = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(dm[0]);

        int m = Integer.parseInt(dm[1]);

        int result = birthday(s, d, m);

        System.out.println(String.valueOf(result));
        
        bufferedReader.close();
    }
}
