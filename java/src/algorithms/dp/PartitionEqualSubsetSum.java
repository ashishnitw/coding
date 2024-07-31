package algorithms.dp;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition(new int[]{1,2,3,5}));
    }

    private static boolean canPartition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0)
            return false;
        // Use Dynamic Programming to check if there exists a subset with a sum equal to totalSum / 2.
        int n = arr.length;
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];   // dp[i] will be true if there exists a subset with sum equal to i.
        dp[0] = true;   // Base case. If the sum is 0, then we can always have an empty subset.
        for(int a : arr) {
            for(int i=target; i>0; i--) {
                if(!dp[i] && a <= i) {
                    dp[i] = dp[i - a];
                }
            }
        }
        return dp[target];
    }
}
