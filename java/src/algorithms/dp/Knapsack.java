package algorithms.dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};

        System.out.println(solveKnapsackRec(profits, weights, 7));
        System.out.println(solveKnapsackTopDown(profits, weights, 7));
        System.out.println(solveKnapsackBottomUp(profits, weights, 7));
        System.out.println(solveKnapsackBottomUpSpaceOptimized(profits, weights, 7));
    }

    // Method 1: Recursion
    public static int solveKnapsackRec(int[] profits, int[] weights, int capacity) {
        return solveKnapsackRecUtil(profits, weights, capacity, 0, profits.length);
    }

    private static int solveKnapsackRecUtil(int[] profits, int[] weights, int capacity, int i, int n) {
        if (i >= n || capacity <= 0)
            return 0;
        int profit1 = 0;
        if (weights[i] <= capacity)
            profit1 = profits[i] + solveKnapsackRecUtil(profits, weights, capacity - weights[i], i + 1, n); // include current item
        int profit2 = solveKnapsackRecUtil(profits, weights, capacity, i + 1, n);   // exclude current item
        return Math.max(profit1, profit2);
    }


    // Method 2: Top-down DP
    public static int solveKnapsackTopDown(int[] profits, int[] weights, int capacity) {
        return 0;
    }

    // Method 3: Bottom-up DP
    public static int solveKnapsackBottomUp(int[] profits, int[] weights, int capacity) {
        return 0;
    }

    // Method 4: Bottom-up DP with space optimization
    public static int solveKnapsackBottomUpSpaceOptimized(int[] profits, int[] weights, int capacity) {
        return 0;
    }

}
