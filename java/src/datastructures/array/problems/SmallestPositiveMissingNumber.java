package datastructures.array.problems;

/**
 * Given an unsorted array arr[] of size N, find the smallest positive number missing from the array.
 * */
public class SmallestPositiveMissingNumber {

    private static int findSmallestPositiveMissingNumber(int[] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {

        }
        return n + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if(i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -7, 6, 8, 1, -10, 15 };
        System.out.println(findSmallestPositiveMissingNumber(arr));
    }
}
