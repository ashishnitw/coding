package algorithms.dp;

public class SubsetSum {

    public static boolean isSubsetSumRec(int[] num, int target) {
        return isSubsetSumRecUtil(num, target, 0, num.length);
    }

    private static boolean isSubsetSumRecUtil(int[] num, int target, int i, int n) {
        if(i >= n || target < 0)
            return false;
        if(num[i] == target)
            return true;
        return isSubsetSumRecUtil(num, target - num[i], i + 1, n) || isSubsetSumRecUtil(num, target, i + 1, n);
    }

    public static boolean canPartition(int[] num, int target) {
        int n = num.length;
        boolean[][] dp = new boolean[n][target+1];
        for(int i=0; i<n; i++)
            dp[i][0] = true;
        for(int t=1; t<=target; t++) {
            if(num[0] == t)
                dp[0][t] = true;
        }
        for(int i=1; i<n; i++) {
            for(int t=1; t<=target; t++) {
                if (dp[i - 1][t])
                    dp[i][t] = dp[i - 1][t];
                else if (num[i] <= t)
                    dp[i][t] = dp[i-1][t - num[i]];
            }
        }
        return dp[n-1][target];
    }
    public static boolean canPartitionOptimized(int[] num, int target) {
        int n = num.length;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for(int t=1; t<=target; t++) {
            if(num[0] == t)
                dp[t] = true;
        }
        for(int i=1; i<n; i++) {
            for(int t=target; t>0; t--) {
                if(!dp[t] && num[i] <= t)
                    dp[t] = dp[t - num[i]];
            }
        }
        return dp[target];
    }
    public static void main(String[] args) {
        int[] num;

        System.out.println("Subset sum recursion -->");
        num = new int[] { 1, 2, 3, 7 };
        System.out.println(isSubsetSumRec(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(isSubsetSumRec(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(isSubsetSumRec(num, 6));

        System.out.println("Subset sum dp -->");
        num = new int[] { 1, 2, 3, 7 };
        System.out.println(canPartition(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(canPartition(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canPartition(num, 6));

        System.out.println("Subset sum dp optimized -->");
        num = new int[] { 1, 2, 3, 7 };
        System.out.println(canPartitionOptimized(num, 6));
        num = new int[] { 1, 2, 7, 1, 5 };
        System.out.println(canPartitionOptimized(num, 10));
        num = new int[] { 1, 3, 4, 8 };
        System.out.println(canPartitionOptimized(num, 6));
    }
}
