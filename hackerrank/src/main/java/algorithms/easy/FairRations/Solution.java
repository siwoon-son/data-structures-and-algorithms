package algorithms.easy.FairRations;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the fairRations function below.
    static int fairRations(int[] B) {
        // 각 시민이 가진 빵의 수가 B이고,
        // 지도자는 빵을 연속된 두 사람에게 하나씩 줄 수 있다면,
        // 모든 사람이 짝수 개의 빵을 갖기 위해 분배해야 할 빵의 최소 개수를 반환한다.

        // 빵의 개수를 0으로 초기화한다.
        int count = 0;
        // 0부터 길이-1까지 반복한다.
        // 즉, 연속된 두 사람씩 묶기 위해 마지막 사람을 제외한다.
        for (int i=0; i<B.length-1; i++) {
            // i-번째 사람이 홀수 개의 빵을 가졌다면,
            if (B[i] % 2 == 1) {
                // i-번째 사람과 i+1번째 사람에게 빵을 하나씩 준다.
                B[i]++;
                B[i+1]++;
                // 빵을 분배한 횟수를 2 증가시킨다.
                count += 2;
            }
        }
        // 분배 후에 마지막 사람이 홀수 개의 빵을 가졌다면 불가능한 상황이므로 -1을 반환한다.
        if (B[B.length-1] % 2 == 1) return -1;
        // 분배 후에 마지막 사람이 짝수 개의 빵을 가졌다면 가능한 상황이므로 count를 반환한다.
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] B = new int[N];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < N; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = fairRations(B);

        // 문제에서 에러를 다음과 같이 수정한다.
        // 결과가 -1이면 불가능한 상황이므로 NO를 출력한다.
        if (result == -1)   System.out.println("NO");
        else    System.out.println(String.valueOf(result));

        scanner.close();
    }
}
