package algorithms.dp;

public class MaximumSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSum(arr));

        int[] arr1 = {5,4,-1,7,8};
        System.out.println(maxSum(arr1));

        int[] arr2 = {2,1,3,4,-1,2,1,5,4};
        System.out.println(maxSum(arr2));

    }

    private static int maxSum(int[] arr) {
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            currMax += i;
            if (currMax > max)
                max = currMax;
            if (currMax < 0)
                currMax = 0;
        }
        return max;
    }
}
