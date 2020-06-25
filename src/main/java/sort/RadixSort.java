package sort;

import java.util.*;

public class RadixSort implements Sort{
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

        new RadixSort().sort(data);

        // after sorting
        System.out.println("*** AFTER ***");
        System.out.print(Arrays.toString(data));
        System.out.println();
    }

    public void sort(int[] data) {
        int max = max(data);

        for (int exp=1; max/exp > 0; exp*=10)
            countsort(data, exp);
    }

    public void countsort(int[] data, int exp) {
        int[] tmp = new int[data.length];
        int[] count = new int[10];

        for (int i=0; i<data.length; i++)
            count[(data[i]/exp)%10]++;

        for (int i=1; i<10; i++)
            count[i] += count[i-1];

        for (int i=data.length-1; i>=0; i--) {
            tmp[ count[(data[i]/exp)%10]-1 ] = data[i];
            count[(data[i]/exp)%10]--;
        }

        for (int i=0; i<data.length; i++)
            data[i] = tmp[i];
    }

    private int max(int[] data) {
        int max = data[0];
        for (int i=1; i<data.length; i++) {
            if (max < data[i]) max = data[i];
        }
        return max;
    }
}
