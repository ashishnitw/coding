package algorithms.dp;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0},
            {0,1,0},
            {0,0,0}
        };
        System.out.println(countPaths(grid));
        int[][] grid2 = {
            {0,1},
            {0,0}
        };
        System.out.println(countPaths(grid2));
    }

    private static int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i=0; i<m; i++) {
            if (grid[i][0] == 1)
                break;
            else
                dp[i][0] = 1;
        }
        for (int j=0; j<n; j++) {
            if (grid[0][j] == 1)
                break;
            else
                dp[0][j] = 1;
        }
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if (grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    // number of ways to reach the cell is the sum of the number of ways to reach the cell above and the cell to the left
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
