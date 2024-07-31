package datastructures.heap.implementation;

import java.util.Arrays;

public class HeapUsingArray {

    private static void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n-1)/2; i >= 0; i--) {
            minHeapify(arr, i, n);
        }
    }

    private static void minHeapify(int[] arr, int i, int n) {
        int smallest = i;
        while (smallest < n / 2) { // check parent nodes only
            int left = (2 * i) + 1; //left child
            int right = (2 * i) + 2; //right child
            if (left < n && arr[left] < arr[i]) {
                smallest = left;
            }
            if (right < n && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if (smallest != i) { // swap parent with smallest child
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
                i = smallest;
            } else {
                break; // if heap property is satisfied
            }
        } //end of while
    }

    public static void buildMaxHeap(int[] arr) {
        // swap largest child to parent node
        int n = arr.length;
        for (int i = (n-1)/2; i >= 0; i--) {
            maxHeapify(arr, i, n);
        }
    }

    private static void maxHeapify(int[] arr, int i, int n) {
        int largest = i;
        while (largest < n/2) {
            int left = (2 * i) + 1;   // left child
            int right = (2 * i) + 2;  // right child
            if (left < n && arr[left] > arr[i]){
                largest = left;
            }
            if (right < n && arr[right] > arr[largest]){
                largest = right;
            }
            if (largest != i){ // swap parent with largest child
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                i = largest;
            }
            else
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };
        System.out.println("Before heapify: "+ Arrays.toString(arr));
        buildMaxHeap(arr);
        System.out.println("Max Heap: " + Arrays.toString(arr));
        buildMinHeap(arr);
        System.out.println("Min Heap: " + Arrays.toString(arr));
    }
}
