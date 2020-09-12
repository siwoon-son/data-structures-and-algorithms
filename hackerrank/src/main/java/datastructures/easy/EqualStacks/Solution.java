package datastructures.easy.EqualStacks;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the equalStacks function below.
     */
    static int equalStacks(int[] h1, int[] h2, int[] h3) {
        // 서로 다른 크기의 원기둥이 여러 개 쌓인 h1, h2, h3에서
        // 원기둥을 하나씩 빼며 높이가 같아지는 가장 큰 높이를 반환한다.

        // 세 개 스택의 높이를 각각 계산한다.
        int height1 = getHeight(h1);
        int height2 = getHeight(h2);
        int height3 = getHeight(h3);

        // 다음으로 빠질 원기둥의 인덱스를 저장한다.
        int last1 = 0;
        int last2 = 0;
        int last3 = 0;

        // 세 스택의 높이가 같아질 때까지 반복한다.
        while (height1 != height2 || height1 != height3) {
            // h1이 가장 높은 경우
            if (height1 >= height2 && height1 >= height3) {
                height1 -= h1[last1];
                last1++;
            }
            // h2가 가장 높은 경우
            else if (height2 >= height1 && height2 >= height3) {
                height2 -= h2[last2];
                last2++;
            }
            // h3가 가장 높은 경우
            else if (height3 >= height1 && height3 >= height2) {
                height3 -= h3[last3];
                last3++;
            }
        }

        return height1;
    }

    private static int getHeight(int[] arr) {
        int height = 0;
        for (int i: arr)
            height += i;
        return height;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] n1N2N3 = scanner.nextLine().split(" ");

        int n1 = Integer.parseInt(n1N2N3[0].trim());

        int n2 = Integer.parseInt(n1N2N3[1].trim());

        int n3 = Integer.parseInt(n1N2N3[2].trim());

        int[] h1 = new int[n1];

        String[] h1Items = scanner.nextLine().split(" ");

        for (int h1Itr = 0; h1Itr < n1; h1Itr++) {
            int h1Item = Integer.parseInt(h1Items[h1Itr].trim());
            h1[h1Itr] = h1Item;
        }

        int[] h2 = new int[n2];

        String[] h2Items = scanner.nextLine().split(" ");

        for (int h2Itr = 0; h2Itr < n2; h2Itr++) {
            int h2Item = Integer.parseInt(h2Items[h2Itr].trim());
            h2[h2Itr] = h2Item;
        }

        int[] h3 = new int[n3];

        String[] h3Items = scanner.nextLine().split(" ");

        for (int h3Itr = 0; h3Itr < n3; h3Itr++) {
            int h3Item = Integer.parseInt(h3Items[h3Itr].trim());
            h3[h3Itr] = h3Item;
        }

        int result = equalStacks(h1, h2, h3);

        System.out.println(String.valueOf(result));
    }
}
