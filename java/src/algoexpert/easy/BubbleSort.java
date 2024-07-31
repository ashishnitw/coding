package algoexpert.easy;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 2, 9, 5, 6, 3};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // Best: O(n) time | O(1) space
    // Average: O(n^2) time | O(1) space
    // Worst: O(n^2) time | O(1) space
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
