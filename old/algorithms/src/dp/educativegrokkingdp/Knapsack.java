package dp.educativegrokkingdp;

public class Knapsack {
  public static int solveKnapsack(int[] p, int[] w, int capacity) {
    return solveKnapsackUtil(p, w, capacity, 0);
  }
  public static int solveKnapsackUtil(int[] p, int[] w, int capacity, int i) {
    if(capacity <= 0 || i >= p.length)
      return 0;
    int profit1 = 0;
    if(w[i] <= capacity)
      profit1 = p[i] + solveKnapsackUtil(p, w, capacity - w[i], i+1);
    int profit2 = solveKnapsackUtil(p, w, capacity, i+1);
    return Math.max(profit1, profit2);
  }
  // Memoization //
  public static int solveKnapsackMemoization(int[] p, int[] w, int capacity) {
    int[][] dp = new int[p.length][capacity + 1];
    return solveKnapsackMemoizationUtil(p, w, capacity, 0, dp);
  }
  public static int solveKnapsackMemoizationUtil(int[] p, int[] w, int capacity, int i, int[][] dp) {
    if(capacity <= 0 || i >= p.length)
      return 0;
    if(dp[i][capacity] != 0)
      return dp[i][capacity];
    int profit1 = p[i] + solveKnapsackUtil(p, w, capacity - w[i], i+1);
    int profit2 = solveKnapsackUtil(p, w, capacity, i+1);
    dp[i][capacity] = Math.max(profit1, profit2);   // save value before returning
    return dp[i][capacity];
  }
  // Tabulation //
  public static int solveKnapsackTabulation(int[] p, int[] w, int capacity) {
    int n = p.length;
    if(capacity <= 0 || n == 0)
      return 0;
    int[][] dp = new int[n][capacity + 1];
    // if we have only one weight, we will take it if it is not more than the capacity
    for(int c=0; c<=capacity; c++) {
      if(w[0] <= c)
        dp[0][c] = p[0];
    }
    // process all sub-arrays for all the capacities
    for(int i=1; i<n; i++) {
      for(int c=1; c<=capacity; c++) {
        int profit1 = 0;
        if(w[i] <= c)
          profit1 = p[i] + dp[i-1][c-w[i]]; // include item
        int profit2 = dp[i-1][c]; // exclude item
        dp[i][c] = Math.max(profit1, profit2);
      }
    }
    return dp[n-1][capacity];
  }
  public static int solveKnapsackTabulationOptimized(int[] p, int[] w, int capacity) {
    int n = p.length;
    if(capacity <= 0 || n == 0)
      return 0;
    int[][] dp = new int[2][capacity + 1];  // we only need one previous row to find the optimal solution, overall we need '2' rows
    // if we have only one weight, we will take it if it is not more than the capacity
    for(int c=0; c<=capacity; c++) {
      if(w[0] <= c)
        dp[0][c] = dp[1][c] = p[0];
    }
    // process all sub-arrays for all the capacities
    for(int i=1; i<n; i++) {
      for(int c=1; c<=capacity; c++) {
        int profit1 = 0;
        if(w[i] <= c)
          profit1 = p[i] + dp[(i-1)%2][c-w[i]]; // include item
        int profit2 = dp[(i-1)%2][c]; // exclude item
        dp[i%2][c] = Math.max(profit1, profit2);
      }
    }
    return dp[(n-1)%2][capacity];
  }
  public static int solveKnapsackTabulationOptimized2(int[] p, int[] w, int capacity) {
    int n = p.length;
    if(capacity <= 0 || n == 0)
      return 0;
    int[] dp = new int[capacity + 1];  // we only need one previous row to find the optimal solution, overall we need '2' rows
    // if we have only one weight, we will take it if it is not more than the capacity
    for(int c=0; c<=capacity; c++) {
      if(w[0] <= c)
        dp[c] = p[0];
    }
    // process all sub-arrays for all the capacities
    for(int i=1; i<n; i++) {
      for(int c=capacity; c>-0; c--) {  // reverse
        int profit1 = 0;
        if(w[i] <= c)
          profit1 = p[i] + dp[c-w[i]]; // include item
        int profit2 = dp[c]; // exclude item
        dp[c] = Math.max(profit1, profit2);
      }
    }
    return dp[capacity];
  }
  public static void main(String[] args) {
    int[] profits = {1, 6, 10, 16};
    int[] weights = {1, 2, 3, 5};
    System.out.println("Total knapsack profit ---> " + solveKnapsack(profits, weights, 7));
    System.out.println("Total knapsack profit ---> " + solveKnapsack(profits, weights, 6));

    System.out.println("Total knapsack profit ---> " + solveKnapsackMemoization(profits, weights, 7));
    System.out.println("Total knapsack profit ---> " + solveKnapsackMemoization(profits, weights, 6));

    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulation(profits, weights, 7));
    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulation(profits, weights, 6));

    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulationOptimized(profits, weights, 7));
    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulationOptimized(profits, weights, 6));

    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulationOptimized2(profits, weights, 7));
    System.out.println("Total knapsack profit ---> " + solveKnapsackTabulationOptimized2(profits, weights, 6));

  }
}
