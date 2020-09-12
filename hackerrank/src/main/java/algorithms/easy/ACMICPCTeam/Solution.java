package algorithms.easy.ACMICPCTeam;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the acmTeam function below.
    static int[] acmTeam(String[] topic) {
        // 0과 1로 구성된 topic 간 1의 합집합이 가장 많은 조합의 수와 그 합집합에서 1의 수를 반환한다.
        // e.g. 11100과 00001의 합집합은 11101이며, 1이 4개이다.
        // topic의 수가 N이면, N*N을 순회하며 합집합을 비교한다.
        // 현재까지 합집합의 1 개수를 저장할 변수를 0으로 초기화한다.
        int maxNOfTopics = 0;
        // 가장 많은 1을 가진 조합의 수를 0으로 초기화한다.
        int nOfPair = 0;

        // 조합의 첫 번째 topic을 0부터 길이-1로 순회한다.
        for (int i=0; i<topic.length-1; i++) {
            String first = topic[i];
            // 조합의 두 번째 topic을 i+1부터 길이로 순회한다.
            for (int j=i+1; j<topic.length; j++) {
                String second = topic[j];

                // 두 topic의 합집합에서 1의 수를 0으로 초기화한다.
                int union = 0;
                // 합집합의 1의 수를 센다.
                for (int k=0; k<first.length(); k++) {
                    if (first.charAt(k) == '1' || second.charAt(k) == '1')
                        union++;
                }
                // 새로운 합집합이 기존 합집합보다 더 많은 1을 가졌다면,
                if (maxNOfTopics < union) {
                    // 1의 수를 교체하고,
                    maxNOfTopics = union;
                    // 조합의 수를 1로 초기화한다.
                    // 즉, 현재까지 가장 많은 조합의 수는 1이다.
                    nOfPair = 1;
                }
                // 새로운 합집합과 기존 합집합의 1의 수가 같다면,
                else if (maxNOfTopics == union) {
                    // 조합의 수를 1 증가시킨다.
                    nOfPair++;
                }
            }
        }

        // 최대 1의 수와 조합의 수를 반환한다.
        return new int[]{maxNOfTopics, nOfPair};
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        String[] topic = new String[n];

        for (int i = 0; i < n; i++) {
            String topicItem = scanner.nextLine();
            topic[i] = topicItem;
        }

        int[] result = acmTeam(topic);

        for (int i = 0; i < result.length; i++) {
            System.out.print(String.valueOf(result[i]));

            if (i != result.length - 1) {
                System.out.println("\n");
            }
        }

        System.out.println();

        scanner.close();
    }
}
