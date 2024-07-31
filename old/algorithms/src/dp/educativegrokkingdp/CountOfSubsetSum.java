package dp.educativegrokkingdp;

public class CountOfSubsetSum {
  public static int countSubsetsRec(int[] num, int sum) {
    return countSubsetsUtil(num, sum, 0);
  }
  public static int countSubsetsUtil(int[] num, int sum, int i) {
    int n = num.length;
    if(sum == 0)
      return 1;
    if(n == 0 || i >= n)
      return 0;
    int sum1 = 0;
    if( num[i] <= sum )
      sum1 = countSubsetsUtil(num, sum - num[i], i + 1);
    int sum2 = countSubsetsUtil(num, sum, i + 1);
    return sum1 + sum2;
  }
  public static int countSubsetsMemo(int[] num, int sum) {
    Integer[][] dp = new Integer[num.length][sum + 1];
    return countSubsetsMemoUtil(dp, num, sum, 0);
  }

  private static int countSubsetsMemoUtil(Integer[][] dp, int[] num, int sum, int currentIndex) {
    // base checks
    if (sum == 0)
      return 1;

    if(num.length == 0 || currentIndex >= num.length)
      return 0;

    // check if we have not already processed a similar problem
    if(dp[currentIndex][sum] == null) {
      // recursive call after choosing the number at the currentIndex
      // if the number at currentIndex exceeds the sum, we shouldn't process this
      int sum1 = 0;
      if( num[currentIndex] <= sum )
        sum1 = countSubsetsMemoUtil(dp, num, sum - num[currentIndex], currentIndex + 1);

      // recursive call after excluding the number at the currentIndex
      int sum2 = countSubsetsMemoUtil(dp, num, sum, currentIndex + 1);

      dp[currentIndex][sum] = sum1 + sum2;
    }

    return dp[currentIndex][sum];
  }
  public static int countSubsetsTabulation(int[] num, int sum) {
    int n = num.length;
    int[][] dp = new int[n][sum + 1];

    // populate the sum=0 columns, as we will always have an empty set for zero sum
    for(int i=0; i < n; i++)
      dp[i][0] = 1;

    // with only one number, we can form a subset only when the required sum is equal to its value
    for(int s=1; s <= sum ; s++) {
      dp[0][s] = (num[0] == s ? 1 : 0);
    }
    // process all subsets for all sums
    for(int i=1; i < num.length; i++) {
      for(int s=1; s <= sum; s++) {
        // exclude the number
        dp[i][s] = dp[i-1][s];
        // include the number, if it does not exceed the sum
        if(s >= num[i])
          dp[i][s] += dp[i-1][s-num[i]];
      }
    }
    // the bottom-right corner will have our answer.
    return dp[num.length-1][sum];
  }
  public static int countSubsetsOptimized(int[] num, int sum) {
    int n = num.length;
    int[] dp = new int[sum + 1];
    dp[0] = 1;

    // with only one number, we can form a subset only when the required sum is equal to its value
    for(int s=1; s <= sum ; s++) {
      dp[s] = (num[0] == s ? 1 : 0);
    }

    // process all subsets for all sums
    for(int i=1; i < num.length; i++) {
      for(int s=sum; s >= 0; s--) {
        if(s >= num[i])
          dp[s] += dp[s-num[i]];
      }
    }
    return dp[sum];
  }
  public static void main(String[] args) {
    int[] num = {1, 1, 2, 3};
    System.out.println(countSubsetsRec(num, 4));
    int[] num2 = {1, 2, 7, 1, 5};
    System.out.println(countSubsetsRec(num2, 9));

    num = new int[]{1, 1, 2, 3};
    System.out.println(countSubsetsMemo(num, 4));
    num2 = new int[]{1, 2, 7, 1, 5};
    System.out.println(countSubsetsMemo(num2, 9));

    num = new int[]{1, 1, 2, 3};
    System.out.println(countSubsetsTabulation(num, 4));
    num2 = new int[]{1, 2, 7, 1, 5};
    System.out.println(countSubsetsTabulation(num2, 9));

    num = new int[]{1, 1, 2, 3};
    System.out.println(countSubsetsOptimized(num, 4));
    num2 = new int[]{1, 2, 7, 1, 5};
    System.out.println(countSubsetsOptimized(num2, 9));

  }
}
