package datastructures.easy.DynamicArray;

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // 주어진 질의들을 수행하며 ArrayList들을 다룬다.
        // (초기화)
        // N개의 빈 시퀀스 seqList를 생성한다.
        // 정수 lastAnswer를 0으로 초기화한다.
        // (질의 1) 1 x y
        // -> (1) seqList에서 ((x ^ lastAnswer) % N) 위치의 리스트 seq를 찾는다.
        // -> (2) seq에 y를 추가한다.
        // (질의 2) 2 x y
        // -> (1) seqList에서 ((x ^ lastAnswer) % N) 위치의 리스트 seq를 찾는다.
        // -> (2) seq의 길이가 size일 때, seq의 y % size 값을 가져와 lastAnswer에 저장한다.
        // -> (3) lastAnswer를 출력 리스트에 담는다.

        // (초기화)
        List<Integer> ret = new ArrayList<>();
        List<Integer>[] seqList = new ArrayList[n];
        for (int i=0; i<n; i++) {
            seqList[i] = new ArrayList<Integer>();
        }
        int lastAnswer = 0;

        // (질의 수행)
        for (List<Integer> query: queries) {
            int x = query.get(1);
            int y = query.get(2);
            int idx = ((x ^ lastAnswer) % n);
            switch (query.get(0)) {
                case 1: // 질의가 1인 경우
                    seqList[idx].add(y);
                    break;
                case 2: // 질의가 2인 경우
                    int size = seqList[idx].size();
                    lastAnswer = seqList[idx].get(y % size);
                    ret.add(lastAnswer);
                    break;
            }
        }

        return ret;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
