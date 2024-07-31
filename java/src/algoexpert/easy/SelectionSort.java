package algoexpert.easy;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
        selectionSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Best: O(n^2) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space
    private static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
