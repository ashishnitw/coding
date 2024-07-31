package algorithms.dp;

public class FibonacciNumber {

    public static void main(String[] args) {
        System.out.println("Using Recursion: " + nthFibonacciNumberRec(5));
        System.out.println("Using DP: " + nthFibonacciNumberDp(5));
        System.out.println("Using Power of Matrix: " + fibDPPowerOfMatrix(5));

        System.out.println("Using Recursion: " + nthFibonacciNumberRec(8));
        System.out.println("Using DP: " + nthFibonacciNumberDp(8));
        System.out.println("Using Power of Matrix: " + fibDPPowerOfMatrix(8));
    }

    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static int nthFibonacciNumberRec(int n) {
        if (n <= 1)
            return n;
        return nthFibonacciNumberRec(n - 1) + nthFibonacciNumberRec(n - 2);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    private static int nthFibonacciNumberDp(int n) {
        if (n <= 1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int nthFibonacciNumberDpOptimized(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, c = 0;
        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public static int fibDPPowerOfMatrix(int n) {
        if(n == 0)
            return 0;
        int[][] F = new int[][]{{1,1},{1,0}};
        power(F, n-1);
        return F[0][0];
    }
    public static void power(int[][] F, int n) {
        int M[][] = new int[][]{{1,1},{1,0}};
        for (int i = 2; i <= n; i++) {
            int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
            int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
            int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
            int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
            F[0][0] = x;
            F[0][1] = y;
            F[1][0] = z;
            F[1][1] = w;
        }
    }
}
