package algoexpert.easy;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        insertionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Best: O(n) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

}
