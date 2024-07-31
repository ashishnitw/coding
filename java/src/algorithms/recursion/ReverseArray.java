package algorithms.recursion;

import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr, int i, int j) {
        if(i >= j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverseArray(arr, i + 1, j - 1);
    }
}
