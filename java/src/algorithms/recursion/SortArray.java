package algorithms.recursion;

import java.util.Arrays;

public class SortArray {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 3, 1, 4};
        sort(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {40, 24, 60, 15, 10, 45, 93};
        sort(arr2, arr2.length);
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr, int n) {
        if (n <= 1)
            return;
        for(int i=0; i<n-1; i++) {
            if(arr[i] > arr[i+1]) {
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        sort(arr, n-1);
    }

}
