package sort;

import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        final int DATA_LENGTH = 10000;
        Random rnd = new Random();

        // create data
        int[] data = new int[DATA_LENGTH];
        for (int i=0; i<DATA_LENGTH; i++) {
            data[i] = rnd.nextInt(DATA_LENGTH * 10);
        }

        // measure selection sort
        System.out.println("SelectionSort:\t" + (measure(data, new SelectionSort())) + "ns");

        // measure bubble sort
        System.out.println("BubbleSort:\t\t" + (measure(data, new BubbleSort())) + "ns");

        // measure insertion sort
        System.out.println("InsertionSort:\t" + (measure(data, new InsertionSort())) + "ns");

        // measure quick sort
        System.out.println("QuickSort:\t\t" + (measure(data, new QuickSort())) + "ns");

        // measure merge sort
        System.out.println("MergeSort:\t\t" + (measure(data, new MergeSort())) + "ns");

        // measure radix sort
        System.out.println("RadixSort:\t\t" + (measure(data, new RadixSort())) + "ns");

        // measure heap sort
        System.out.println("HeapSort:\t\t" + (measure(data, new HeapSort())) + "ns");
    }

    private static long measure(int[] data, Sort sort) {
        int[] copied = new int[data.length];
        System.arraycopy(data, 0, copied, 0, data.length);
        long stime = System.nanoTime();
        sort.sort(copied);
        long etime = System.nanoTime();
        return etime - stime;
    }
}
