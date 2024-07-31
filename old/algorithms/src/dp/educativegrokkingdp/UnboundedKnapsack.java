package dp.educativegrokkingdp;

public class UnboundedKnapsack {
  public static int solveKnapsackRec(int[] profits, int[] weights, int capacity) {
    return solveKnapsackRecUtil(profits, weights, capacity, 0);
  }
  private static int solveKnapsackRecUtil(int[] profits, int[] weights, int capacity, int i) {
    if(capacity <= 0 || profits.length == 0 || i >= profits.length)
      return 0;
    int profit1 = 0;
    if(weights[i] <= capacity)
      profit1 = profits[i] + solveKnapsackRecUtil(profits, weights, capacity-weights[i], 1);
    int profit2 = solveKnapsackRecUtil(profits, weights, capacity, i+1);
    return Math.max(profit1, profit2);
  }
  public static int solveKnapsackMemo(int[] profits, int[] weights, int capacity) {
    Integer[][] dp = new Integer[profits.length][capacity + 1];
    return solveKnapsackMemoUtil(dp, profits, weights, capacity, 0);
  }
  private static int solveKnapsackMemoUtil(Integer[][] dp, int[] profits, int[] weights, int capacity, int i) {
    if(capacity <= 0 || profits.length == 0 || i >= profits.length)
      return 0;
    if(dp[i][capacity] == null) {
      // recursive call after choosing the items at the currentIndex, note that we recursive call on all
      // items as we did not increment currentIndex
      int profit1 = 0;
      if( weights[i] <= capacity )
        profit1 = profits[i] + solveKnapsackMemoUtil(dp, profits, weights, capacity - weights[i], i);
      // recursive call after excluding the element at the currentIndex
      int profit2 = solveKnapsackMemoUtil(dp, profits, weights, capacity, i + 1);

      dp[i][capacity] = Math.max(profit1, profit2);
    }
    return dp[i][capacity];
  }
  public static int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
    if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
      return 0;
    int n = profits.length;
    int[][] dp = new int[n][capacity + 1];
    // populate the capacity=0 columns
    for(int i=0; i < n; i++)
      dp[i][0] = 0;
    // process all sub-arrays for all capacities
    for(int i=0; i < n; i++) {
      for(int c=1; c <= capacity; c++) {
        int profit1=0, profit2=0;
        if(weights[i] <= c)
          profit1 = profits[i] + dp[i][c-weights[i]];
        if( i > 0 )
          profit2 = dp[i-1][c];
        dp[i][c] = profit1 > profit2 ? profit1 : profit2;
      }
    }
    // maximum profit will be in the bottom-right corner.
    return dp[n-1][capacity];
  }

  public static void main(String[] args) {
    int[] profits = {15, 50, 60, 90};
    int[] weights = {1, 3, 4, 5};
    System.out.println(solveKnapsackRec(profits, weights, 8));
    System.out.println(solveKnapsackRec(profits, weights, 6));

    System.out.println(solveKnapsackMemo(profits, weights, 8));
    System.out.println(solveKnapsackMemo(profits, weights, 6));

    System.out.println(solveKnapsackBottomUp(profits, weights, 8));
    System.out.println(solveKnapsackBottomUp(profits, weights, 6));
  }
}
