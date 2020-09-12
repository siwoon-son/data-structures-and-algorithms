package sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort implements Sort{
    public static void main(String[] args) {
        final int DATA_LENGTH = 10;
        Random rnd = new Random();
        
        // create data
        int[] data = new int[DATA_LENGTH];
        for (int i=0; i<DATA_LENGTH; i++) {
            data[i] = rnd.nextInt(100);
        }

        // before sorting
        System.out.println("*** BEFORE ***");
        System.out.print(Arrays.toString(data));
        System.out.println();

        new QuickSort().sort(data);

        // after sorting
        System.out.println("*** AFTER ***");
        System.out.print(Arrays.toString(data));
        System.out.println();
    }

    public void sort(int[] data) {
        quicksort(data, 0, data.length-1);
    }

    private void quicksort(int[] data, int left, int right) {
        if (left >= right) return;

        int pivot = partition(data, left, right);
        quicksort(data, left, pivot-1);
        quicksort(data, pivot+1, right);
    }

    private int partition(int[] data, final int left, final int right) {
        int j = left;

        for (int i=left+1; i<=right; i++) {
            if (data[i] < data[left]) {
                j++;
                swap(data, i, j);
            }
        }

        swap(data, left, j);
        return j;
    }

    private void swap(int[] data, int i, int j) {
        if (i == j) return ;
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
