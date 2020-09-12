package algorithms.medium.BearAndSteadyGene;

import java.io.*;
import java.util.*;

public class Solution {

    // Complete the steadyGene function below.
    static int steadyGene(String gene) {
        // 참고: https://gocodergo.wordpress.com/2016/07/24/hackerrank-bear-and-steady-gene/

        // 'A', 'C', 'T', 'G'로 구성된 유전자 gene에서 모든 문자가 같은 빈도를 가지면 steady하다.
        // gene의 substring을 교체하여 steady하게 만드려고 한다.
        // substring의 최소 길이를 반환하자.

        // gene.length()/4 보다 많은 문자들을 포함하는 substring을 찾으려 했으나 시간초과가 발생했다.
        // 위의 참고를 토대로 다음과 같이 구현한다.

        // 먼저, 문자를 배열 인덱스로 바꿀 map을 생성한다.
        Map<Character, Integer> geneToIdx = new HashMap<>();
        geneToIdx.put('A', 0); geneToIdx.put('C', 1);
        geneToIdx.put('T', 2); geneToIdx.put('G', 3);

        // 문자열을 문자의 배열로 변환한다.
        char[] chars = gene.toCharArray();

        // 문자들의 빈도수를 계산한다.
        int[] count = new int[4];
        for (char c: chars) count[geneToIdx.get(c)]++;

        // substring의 왼쪽, 오른쪽 인덱스를 0으로 초기화한다.
        int left = 0, right = 0;
        // 바꿔야할 개수를 문자열 길이로 초기화한다.
        int changed = chars.length;
        // 왼쪽 인덱스가 gene 길이가 될 때까지 반복한다.
        while (left < chars.length) {
            // substring을 제외한 나머지의 빈도수가
            // 최대 길이의 4로나눈 것보다 작을 때까지 오른쪽 인덱스를 증가시킨다.
            while (right < chars.length && !isSteady(count, chars.length/4)) {
                count[geneToIdx.get(chars[right])]--;
                right++;
            }
            // substring을 제외한 나머지의 빈도수가 최대 길이의 4로 나눈 것보다 모두 작다면,
            if (isSteady(count, chars.length/4))
                // 바꿔야할 개수의 최소값을 대체한다.
                changed = Math.min(changed, right-left);
            // 왼쪽 값을 substring을 제외한 나머지에 다시 추가한다.
            count[geneToIdx.get(chars[left])]++;
            // 왼쪽 인덱스를 하나 증가시킨다.
            left++;
            // 이러한 반복은 모든 유효한 substring을 순회하며,
            // 가장 작은 길이를 찾아낸다.
        }

        return changed;
    }

    static boolean isSteady(int[] count, int limit) {
        return count[0] <= limit && count[1] <= limit &&
                count[2] <= limit && count[3] <= limit;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String gene = scanner.nextLine();

        int result = steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
