package sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort implements Sort {
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

        new MergeSort().sort(data);

        // after sorting
        System.out.println("*** AFTER ***");
        System.out.print(Arrays.toString(data));
        System.out.println();
    }

    public void sort(int[] data) {
        mergesort(data, 0, data.length-1);
    }

    private void mergesort(int[] data, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergesort(data, low, mid);
        mergesort(data,mid+1, high);
        merge(data, low, mid, high);
    }

    private void merge(int[] data, int low, int mid, int high) {
        int[] tmp = new int[high-low+1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (data[i] < data[j]) {
                tmp[k] = data[i];
                i++;
            } else {
                tmp[k] = data[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            tmp[k] = data[i];
            k++; i++;
        }
        while (j <= high) {
            tmp[k] = data[j];
            k++; j++;
        }
        for (k=0; k<tmp.length; k++, low++) {
            data[low] = tmp[k];
        }
    }
}
