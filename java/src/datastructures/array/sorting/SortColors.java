package datastructures.array.sorting;

import java.util.Arrays;

/**
 * To solve the problem of sorting an array of colors in-place with the colors in the order red, white, and blue,
 * you can use the Dutch National Flag algorithm proposed by Edsger W. Dijkstra.
 * This algorithm uses three pointers to partition the array into three sections: one for each color.
 * */
public class SortColors {

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println("Sorted colors: " + Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int low = 0;      // will point to the boundary of the red region.
        int mid = 0;      // will traverse the array.
        int high = nums.length - 1;    // will point to the boundary of the blue region.
        while(mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
