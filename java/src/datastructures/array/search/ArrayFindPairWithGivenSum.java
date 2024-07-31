package datastructures.array.search;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayFindPairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        int sum = 16;
        findPairWithGivenSum(arr, sum);
        findPairWithGivenSum2(arr, sum);
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static boolean findPairWithGivenSum(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(sum - i)) {
                System.out.println("Pair with given sum " + sum + " is (" + i + ", " + (sum - i) + ")");
                return true;
            }
            set.add(i);
        }
        return false;
    }

    // This method uses the technique of Sorting and Two pointers to arrive at the solution
    // This method is not recommended as it changes the order of elements in the array
    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    private static boolean findPairWithGivenSum2(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        Arrays.sort(arr);
        while(i < j) {
            if (arr[i] + arr[j] < sum) {
                i++;
            } else if (arr[i] + arr[j] > sum) {
                j--;
            } else {
                System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + arr[j] + ")");
                return true;
            }
        }
        return false;
    }
}
