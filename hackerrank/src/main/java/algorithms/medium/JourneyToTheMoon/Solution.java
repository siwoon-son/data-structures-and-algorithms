package algorithms.medium.JourneyToTheMoon;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {
        // * int 범위를 벗어나는 case가 있어 return type을 int에서 long으로 변경하였다.

        // 2명씩 짝지어진 우주비행사들이 주어진다.
        // 짝지어진 비행사들은 같은 국가 소속이다.
        // n명의 비행사로부터 서로 다른 국가인 짝의 수를 반환한다.

        // 모든 경우의 수를 nC2로 계산한다.
        long nOfCases = (long) n * (n-1) / 2;

        // i-번째 비행사가 속한 국가의 그룹을 Set array로 정의한다.
        Set<Integer>[] astronautByCountry = new HashSet[n];
        for (int[] pair: astronaut) {
            // pair에서 left와 right 모두 처음 등장한 비행사면,
            if (astronautByCountry[pair[0]] == null && astronautByCountry[pair[1]] == null) {
                // 새로운 Set을 만들고,
                Set<Integer> created = new HashSet<>();
                // 두 비행사를 추가하여,
                created.add(pair[0]); created.add(pair[1]);
                // Set array에 동일한 객체를 저장한다.
                astronautByCountry[pair[0]] = astronautByCountry[pair[1]] = created;
            }
            // 오른쪽 비행사는 이미 등장했다면,
            else if (astronautByCountry[pair[0]] == null) {
                // 오른쪽 비행사의 그룹을 가져와,
                Set<Integer> right = astronautByCountry[pair[1]];
                // 왼쪽 비행사를 저장하고,
                right.add(pair[0]);
                // 왼쪽 비행사의 그룹으로 지정한다.
                astronautByCountry[pair[0]] = right;
            }
            // 왼쪽 비행사는 이미 등장했다면,
            else if (astronautByCountry[pair[1]] == null){
                // 왼쪽 비행사의 그룹을 가져와,
                Set<Integer> left = astronautByCountry[pair[0]];
                // 오른쪽 비행사를 저장하고,
                left.add(pair[1]);
                // 오른쪽 비행사의 그룹으로 지정한다.
                astronautByCountry[pair[1]] = left;
            }
            // 두 비행사 모두 등장했다면,
            else {
                // 두 비행사의 그룹을 가져와,
                Set<Integer> left = astronautByCountry[pair[0]];
                Set<Integer> right = astronautByCountry[pair[1]];
                // 왼쪽 비행사의 그룹에 merge하고,
                left.addAll(right);
                // 모든 비행사 그룹에 반영한다.
                for (int i=0; i<n; i++)
                    // 오른쪽 비행사와 같은 객체임이 중요하다.
                    if (astronautByCountry[i] == right)
                        astronautByCountry[i] = left;
            }
        }

        // 비행사들의 그룹을 하나씩 가져온다.
        for (Set<Integer> country: astronautByCountry) {
            // 그룹이 null이면 무시한다.
            if (country == null) continue;
            // 그룹 내에서는 짝을 지을 수 없으니 해당 경우의 수만큼 제외한다.
            nOfCases -= (country.size() * (country.size()-1) / 2);
            // 그룹을 비워 같은 객체를 가리키는 비행사들은 더이상 연산하지 않는다.
            country.clear();
        }

        return nOfCases;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
