package algorithms.easy.CorrectnessAndTheLoopInvariant;

import java.util.*;

public class Solution {

    /**
     * {@link algorithms.easy.InsertionSortPart2.Solution#insertionSort2(int, int[])}
     */
    public static void insertionSort(int[] A){
        // 삽입 정렬 코드를 정상적으로 수정한다.
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            // subarray의 첫번째 원소를 비교하지 않는다.
            // while(j > 0 && A[j] > value){
            // 아래와 같이 수정한다.
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        insertionSort(ar);
    }
}