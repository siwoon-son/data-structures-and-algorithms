package hackerrank.datastructures.easy.JesseAndCookies;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the cookies function below.
     */
    static int cookies(int k, int[] A) {
        // A에는 쿠키들의 당도?가 들어있다.
        // A에서 가장 낮은 당도의 쿠키과 두 번째로 낮은 당도의 쿠기를 섞으면,
        // 다음과 같은 새로운 당도의 쿠키를 만들 수 있다.
        // 가장 낮은 당도 + 두 번째로 낮은 당도 * 2

        // 모든 쿠키의 당도가 k 이상이 되려면,
        // 최소 몇번의 섞는 작업이 필요한가?
        // 불가능하면 -1을 반환한다.

        // 당도들을 오름차순으로 정렬하고,
        // 새로운 쿠키의 당도도 오름차순으로 삽입되어야 한다.
        // 가장 낮은 당도가 k 이상이면, 조건을 만족한다.
        // 이를 위해 우선 순위 큐를 사용한다.
        PriorityQueue<Integer> sweetness = new PriorityQueue<>();
        for (int a: A) {
            sweetness.add(a);
        }

        // 섞는 작업의 수를 기록한다.
        int count = 0;
        // 현재 쿠키의 수가 2개 이상이고, 아직 가장 낮은 당도가 k보다 낮으면,
        while (sweetness.size() >= 2 && sweetness.peek() < k) {
            // 섞는 작업을 수행한다.
            count++;
            int first = sweetness.poll();
            int second = sweetness.poll();
            // 새로운 쿠키의 당도는 오름차순으로 정렬된다.
            sweetness.add(first + second * 2);
        }

        // 여전히 가장 낮은 당도가 k보다 낮으면,
        if (sweetness.peek() < k)
            // 더이상 불가능하므로 -1을 반환한다.
            return -1;
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0].trim());

        int k = Integer.parseInt(nk[1].trim());

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");

        for (int AItr = 0; AItr < n; AItr++) {
            int AItem = Integer.parseInt(AItems[AItr].trim());
            A[AItr] = AItem;
        }

        int result = cookies(k, A);

        System.out.println(String.valueOf(result));
    }
}
