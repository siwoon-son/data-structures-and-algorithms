package algorithms.easy.MigratoryBirds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        // 정수로 식별되는 새들 중, 가장 많은 수의 새를 찾는다.
        // 만약, 가장 많은 수의 새가 다수이면, 더 작은 식별 id를 반환한다.

        // Constraints가 복잡도를 줄일 가장 중요한 단서이다.
        // 새의 종류는 1부터 5까지, 다섯 가지이다.
        // 따라서, 1부터 5까지의 새 빈도수를 쉽게 저장할 수 있는 길이 6의 배열을 생성한다.
        int[] counts = new int[6];

        // List arr을 순회하며 counts를 증가시킨다.
        for (int i: arr) {
            counts[i]++;
        }

        // counts에서 가장 값이 큰 인덱스를 가져온다.
        int maxCount = 0;
        int maxType = 0;
        for (int i=1; i<=5; i++) {
            // 가장 많은 새가 다수일 경우를 대비하여 = 연산자는 포함하지 않는다.
            if (maxCount < counts[i]) {
                maxCount = counts[i];
                maxType = i;
            }
        }

        return maxType;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr.add(arrItem);
        }

        int result = migratoryBirds(arr);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}
