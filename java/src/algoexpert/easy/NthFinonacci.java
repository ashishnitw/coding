package algoexpert.easy;

public class NthFinonacci {
    public static void main(String[] args) {
        System.out.println(getNthFibRecursive(10));
        System.out.println(getNthFibRecursive(20));
        System.out.println(getNthFib(10));
        System.out.println(getNthFib(20));
    }

    // Time Complexity: O(2^n)
    // Space Complexity: O(n)
    private static int getNthFibRecursive(int n) {
        if (n <= 1)
            return 0;
        else if (n == 2)
            return 1;
        else
            return getNthFibRecursive(n - 1) + getNthFibRecursive(n - 2);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static int getNthFib(int n) {
        if (n < 2)
            return n;
        int x2 = 0;
        int x1 = 1;
        for (int i=2; i<n; i++) {
            int next = x1 + x2;
            x2 = x1;
            x1 = next;
        }
        return x1;
    }
}
