package algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int i, int j) {
        if (i >= j)
            return;
        int mid = (i + j) / 2;
        // Divide the array into two halves
        // Recursively sort the two halves
        mergeSort(arr, i, mid);
        mergeSort(arr, mid+1, j);
        // Merge the two halves
        merge(arr, i, mid, j);
    }

    private static void merge(int[] arr, int i, int mid, int j) {
        int n1 = mid - i + 1;
        int n2 = j - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int x = 0; x < n1; x++) {
            left[x] = arr[i + x];
        }
        for (int x = 0; x < n2; x++) {
            right[x] = arr[mid + 1 + x];
        }
        int x = 0, y = 0, k = i;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 3, 4};
        sort(arr);
        System.out.println("Merge Sort: " + Arrays.toString(arr));
    }
}
