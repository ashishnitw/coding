package datastructures.heap.problems;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;
        kLargestElements(arr, k);
    }

    private static void kLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // MinHeap
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k)
                pq.poll();
        }
        for (int i = 0; i < k; i++) {
            System.out.print(pq.poll() + " ");
        }
    }
}
