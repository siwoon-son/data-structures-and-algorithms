package hackerrank.algorithms.easy.BeautifulPairs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the beautifulPairs function below.
    // refer to https://github.com/RodneyShag/HackerRank_solutions/blob/master/Algorithms/Greedy/Beautiful%20Pairs/Solution.java
    static int beautifulPairs(int[] A, int[] B) {
        // 정렬없이 더 효율적인 소스코드를 참조한다.
        // Input의 constraints가 1,000개이므로 1,001개의 정수 배열 bucket을 생성한다.
        int[] bucket = new int[1001];
        // Array A의 모든 원소를 bucket에 저장한다.
        for (int a: A) {
            bucket[a]++;
        }


        // Array A와 Array B가 동일한 수를 저장할 변수를 초기화한다.
        int nOfPairs = 0;
        // Array B를 순회하며 비교한다.
        for (int b: B) {
            // Array B의 원소가 bucket에 있다면, 즉 동일한 수가 있다면,
            if (bucket[b] > 0) {
                // Array bucket에서 해당 원소를 제거하고,
                bucket[b]--;
                // 동일한 개수를 증가시킨다.
                nOfPairs++;
            }
        }

        // Array B의 원소를 하나만 바꿔야 하므로,
        // B의 길이가 발견한 개수와 같으면 하나의 중복을 제외하고,
        // B의 길이가 발견한 개수와 다르면 다른 경우 하나를 바꾼다고 가정한다.
        return nOfPairs == B.length ? nOfPairs - 1 : nOfPairs + 1;

    //     // 기존 코드
    //     // Array A의 원소와 Array B의 원소를 빠르게 비교하기 위해 정렬한다.
    //    Arrays.sort(A);
    //    Arrays.sort(B);
    //     // Array A와 Array B의 인덱스를 초기화한다.
    //    int indexA = 0;
    //    int indexB = 0;

    //     // 두 array에서 같은 원소의 개수를 저장할 변수를 초기화한다.
    //    int len = 0;
    //     // 정렬된 Array A와 Array B를 순차 탐색한다. 
    //    while (indexA < A.length && indexB < B.length) {
    //        // 두 array의 원소가 같다면,
    //        if (A[indexA] == B[indexB]) {
    //            // Array A의 인덱스와 Array B의 인덱스를 한칸 이동시킨다.
    //            indexA++;
    //            indexB++;
    //            // 같은 원소의 개수를 하나 증가시킨다.
    //            len++;
    //        }
    //        // Array A의 원소가 Array B의 원소보다 크면, B의 인덱스를 한칸 이동시킨다.
    //        else if (A[indexA] > B[indexB]) indexB++;
    //        // Array A의 원소가 Array B의 원소보다 작으면, A의 인덱스를 한칸 이동시킨다.
    //        else indexA++;
    //    }

    //    // Array B의 원소를 하나만 바꿔야 하므로,
    //    // B의 길이가 발견한 개수와 같으면 하나의 중복을 제외하고,
    //    // B의 길이가 발견한 개수와 다르면 다른 경우 하나를 바꾼다고 가정한다.
    //    return B.length == len ? len - 1 : len + 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] A = new int[n];

        String[] AItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(AItems[i]);
            A[i] = AItem;
        }

        int[] B = new int[n];

        String[] BItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int BItem = Integer.parseInt(BItems[i]);
            B[i] = BItem;
        }

        int result = beautifulPairs(A, B);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
