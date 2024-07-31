package algorithms.dp;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        // Create a 2D array to store the number of unique paths to reach each cell
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++)
            dp[i][0] = 1;   // There is only one way to reach the cells in the first column
        for (int j=0; j<n; j++)
            dp[0][j] = 1;   // There is only one way to reach the cells in the first row
        // The number of unique paths to reach a cell is the sum of the number of unique paths to reach the cell above and the cell to the left
        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
