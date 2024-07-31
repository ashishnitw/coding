package datastructures.array.problems;

public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        System.out.println("Maximum product of subarray: " + maxProduct(nums));
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(nums[i], Math.max(maxProduct * nums[i], minProduct * nums[i]));
            minProduct = Math.min(nums[i], Math.min(temp * nums[i], minProduct * nums[i]));
            result = Math.max(result, maxProduct);
        }
        return result;
    }
}
