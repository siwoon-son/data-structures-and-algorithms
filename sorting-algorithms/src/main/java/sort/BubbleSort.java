package sort;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort implements Sort{
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

        new BubbleSort().sort(data);

        // after sorting
        System.out.println("*** AFTER ***");
        System.out.print(Arrays.toString(data));
        System.out.println();
    }

    public void sort(int[] data) {
        for (int i=0; i<data.length-1; i++) {
            for (int j=i+1; j<data.length; j++) {
                if (data[i] > data[j])
                    swap(data, i, j);
            }
        }
    }

    private static void swap(int[] data, int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
