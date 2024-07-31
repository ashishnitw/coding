package datastructures.heap.problems;

import java.util.Arrays;

public class ConvertMaxHeapToMinHeap {
    public static int[] convertMax(int[] heapList) {
        //MinHeap.buildMinHeap(heapList, heapList.length);
        return heapList;
    }
    public static void main(String args[]) {
        int[] heapList = {9,4,7,1,-2,6,5};
        System.out.println(Arrays.toString(convertMax(heapList)));
    }
}
