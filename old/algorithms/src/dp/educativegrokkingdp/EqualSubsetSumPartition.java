package dp.educativegrokkingdp;

public class EqualSubsetSumPartition {
  static boolean canPartition(int[] num) {
    int sum = 0;
    for(int i=0; i<num.length; i++) {
      sum += num[i];
    }
    if(sum%2 != 0)
      return false;
    return canPartitionUtil(num, sum/2, 0);
  }
  static boolean canPartitionUtil(int[] num, int sum, int i) {
    if(sum == 0)
      return true;
    if(num.length == 0 || i >= num.length)
      return false;
    if(num[i] <= sum)
      if (canPartitionUtil(num, sum-num[i], i+1))
        return true;
    return canPartitionUtil(num, sum, i+1);
  }
  static boolean canPartitionMemo(int[] num) {
    int sum = 0;
    for(int i=0; i<num.length; i++) {
      sum += num[i];
    }
    if(sum%2 != 0)
      return false;
    Boolean[][] dp = new Boolean[num.length][sum / 2 + 1];
    return canPartitionMemoUtil(num, sum/2, 0, dp);
  }
  static boolean canPartitionMemoUtil(int[] num, int sum, int i, Boolean[][] dp) {
    if(sum == 0)
      return true;
    if(num.length == 0 || i >= num.length)
      return false;
    if (dp[i][sum] == null) {
      if(num[i] <= sum) {
        if (canPartitionUtil(num, sum - num[i], i + 1)) {
          dp[i][sum] = true;
          return true;
        }
      }
      dp[i][sum] = canPartitionUtil(num, sum, i+1);
    }
    return dp[i][sum];
  }
  static boolean canPartitionBottomUp(int[] num) {
    int n = num.length;
    int sum = 0;
    for(int i=0; i<n; i++) {
      sum += num[i];
    }
    if(sum%2 != 0)
      return false;
    sum = sum/2;
    boolean[][] dp = new boolean[n][sum+1];
    for(int s=0; s<sum; s++) {
      dp[0][s] = num[0] == s ? true : false;
    }
    for(int i=1; i<n; i++) {
      for(int s=1; s<=sum; s++) {
        if(dp[i-1][s])
          dp[i][s] = dp[i-1][s];
        else if(num[i] <= s)
          dp[i][s] = dp[i][s-num[i]];
      }
    }
    return dp[n-1][sum];
  }
  public static void main(String[] args) {
    int[] num;
    num = new int[]{1, 2, 3, 4};
    System.out.println(canPartition(num));
    num = new int[]{1, 1, 3, 4, 7};
    System.out.println(canPartition(num));
    num = new int[]{2, 3, 4, 6};
    System.out.println(canPartition(num));

    num = new int[]{1, 2, 3, 4};
    System.out.println(canPartitionMemo(num));
    num = new int[]{1, 1, 3, 4, 7};
    System.out.println(canPartitionMemo(num));
    num = new int[]{2, 3, 4, 6};
    System.out.println(canPartitionMemo(num));

    num = new int[]{1, 2, 3, 4};
    System.out.println(canPartitionBottomUp(num));
    num = new int[]{1, 1, 3, 4, 7};
    System.out.println(canPartitionBottomUp(num));
    num = new int[]{2, 3, 4, 6};
    System.out.println(canPartitionBottomUp(num));

  }
}
