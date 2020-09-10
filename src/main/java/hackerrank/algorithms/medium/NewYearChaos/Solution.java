package hackerrank.algorithms.medium.NewYearChaos;

import java.io.*;
import java.math.*;
import java.security.*;
import java.sql.SQLOutput;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        // 참고: https://www.martinkysel.com/hackerrank-new-year-chaos-solution/

        // 사람들이 1부터 n까지 번호표를 가지고 줄 서있다.
        // 이때, 사람들은 최대 두 번까지 뇌물을 주고 바로 앞사람과 자리를 바꿀 수 있다.
        // 주어진 배열 q를 보고, 뇌물을 최소 몇번을 줬을지 계산하자.
        // 만약, 어떤 사람이 두 번 초과의 뇌물을 줬다면, "Too chaotic"을 출력한다.

        // 먼저, 현재 번호가 원래 위치와 2 초과 차이나면, 두 번을 초과하여 뇌물을 준 것이다.
        // 다음으로, 어떤 사람이 뇌물을 받으면 한 칸 뒤로 가야한다.
        // 따라서, 현재 위치 앞에 나보다 높은 번호를 가진 사람 수만큼 뇌물을 받은 것이다.
        // 이때, 원래 위치의 바로 앞 사람부터 현재 위치까지를 비교하면, 비교회수를 줄일 수 있다.
        // 예를 들어, [1, 4, 2, 3, 5]이라면, 3번 사람은 두 번째(4)부터 현재 위치 앞(2)까지 자신보다 높은 숫자의 수를 센다.

        int nOfBribes = 0;

        for (int i=0; i<q.length; i++) {
            // 두 번을 초과한 경우
            if (q[i] - (i+1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // 원래 위치의 바로 앞 부터 현재 위치의 바로 앞까지 자신보다 높은 숫자의 수를 센다.
            for (int j=Math.max(0, q[i]-2); j < i; j++) {
                if (q[j] > q[i])
                    nOfBribes++;
            }
        }

        System.out.println(nOfBribes);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
