package dp.educativegrokkingdp;

public class MinimumSubsetSumDifference {
  private static int minSumDiff(int[] num) {
    return minSumDiffUtil(num, 0, 0, 0);
  }

  private static int minSumDiffUtil(int[] num, int i, int sum1, int sum2) {
    if(i == num.length)
      return Math.abs(sum1 - sum2);
    int diff1 = minSumDiffUtil(num, i+1, sum1+num[i], sum2);
    int diff2 = minSumDiffUtil(num, i+1, sum1, sum2+num[i]);
    return Math.min(diff1, diff2);
  }
  private static int minSumDiffMemo(int[] num) {
    int n = num.length;
    int sum = 0;
    for(int i=0; i<n; i++)
      sum += num[i];
    Integer dp[][] = new Integer[n][sum + 1];
    return minSumDiffMemoUtil(num, dp, 0, 0, 0);
  }

  private static int minSumDiffMemoUtil(int[] num, Integer[][] dp, int i, int sum1, int sum2) {
    if(i == num.length)
      return Math.abs(sum1 - sum2);
    if(dp[i][sum1] == null) {
      int diff1 = minSumDiffUtil(num, i+1, sum1+num[i], sum2);
      int diff2 = minSumDiffUtil(num, i+1, sum1, sum2+num[i]);
      dp[i][sum1] = Math.min(diff1, diff2);
    }
    return dp[i][sum1];
  }
  private static int minSumDiffMemoBottomUp(int[] num) {
    int n = num.length;
    int totalSum = 0;
    for(int i=0; i<n; i++)
      totalSum += num[i];
    int sum = totalSum/2;
    boolean[][] dp = new boolean[n][sum + 1];
    for(int i=0; i<n; i++)
      dp[i][0] = true;
    for(int s=0; s<=sum; s++)
      dp[0][s] = num[0] == s ? true : false;
    for(int i=1; i<n; i++) {
      for(int s=1; s<=sum; s++) {
        if(dp[i-1][s]) {
          dp[i][s] = dp[i-1][s];  // exclude
        } else if (num[i] <= s) {
          dp[i][s] = dp[i-1][s-num[i]];  // include
        }
      }
    }
    int sum1 = 0;
    // Find the largest index in the last row which is true
    for (int i = sum; i >= 0; i--) {
      if (dp[n-1][i] == true) {
        sum1 = i;
        break;
      }
    }
    int sum2 = totalSum - sum1;
    return Math.abs(sum2-sum1);
  }

  public static void main(String[] args) {
    int[] num;
    num = new int[]{1, 2, 3, 9};
    System.out.println(minSumDiff(num));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(minSumDiff(num));
    num = new int[]{1, 3, 100, 4};
    System.out.println(minSumDiff(num));

    num = new int[]{1, 2, 3, 9};
    System.out.println(minSumDiffMemo(num));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(minSumDiffMemo(num));
    num = new int[]{1, 3, 100, 4};
    System.out.println(minSumDiffMemo(num));

    num = new int[]{1, 2, 3, 9};
    System.out.println(minSumDiffMemoBottomUp(num));
    num = new int[]{1, 2, 7, 1, 5};
    System.out.println(minSumDiffMemoBottomUp(num));
    num = new int[]{1, 3, 100, 4};
    System.out.println(minSumDiffMemoBottomUp(num));
  }
}
