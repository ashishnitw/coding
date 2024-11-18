package algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            int j = i-1;
            int temp = arr[i];
            while(j >= 0 && temp < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 3, 4};
        sort(arr);
        System.out.println("Original array: " + Arrays.toString(arr));
    }
}
