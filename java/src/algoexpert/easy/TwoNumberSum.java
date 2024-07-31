package algoexpert.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] arr = {3, 5, -4, 8, 11, 1, -1, 6};
        int target = 10;
        int[] result = twoNumberSum(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

    // Time Complexity: O(n) and Space Complexity: O(n)
    private static int[] twoNumberSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            int temp = target - arr[i];
            if (map.containsKey(temp))
                return new int[]{map.get(temp), i};
            else
                map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }
}
