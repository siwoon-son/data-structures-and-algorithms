package sort;

import java.util.Arrays;
import java.util.Random;

public class HeapSort implements Sort {
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

        new HeapSort().sort(data);

        // after sorting
        System.out.println("*** AFTER ***");
        System.out.print(Arrays.toString(data));
        System.out.println();
    }

    public void sort(int[] data) {
        MaxHeap heap = new MaxHeap(data.length);

        for (int i=0; i<data.length; i++) {
            heap.push(data[i]);
        }

        for (int i=data.length-1; i>=0; i--) {
            data[i] = heap.pop();
        }
    }

    private class MaxHeap {
        int heapSize = 0;
        int[] heap;
        MaxHeap (int maxHeapSize) {
            this.heap = new int[maxHeapSize+1];
        }
        void push (int item) {
            int i = ++heapSize;

            while ((i != 1) && (item > heap[i/2])) {
                heap[i] = heap[i/2];
                i /= 2;
            }
            heap[i] = item;
        }
        int pop () {
            int parent, child;
            int item, temp;

            item = heap[1];
            temp = heap[heapSize--];
            parent = 1;
            child = 2;

            while (child <= heapSize) {
                if ((child < heapSize) && (heap[child] < heap[child+1])) {
                    child++;
                }

                if (temp >= heap[child]) {
                    break;
                }

                heap[parent] = heap[child];
                parent = child;
                child *= 2;
            }

            heap[parent] = temp;
            return item;
        }
    }
}
