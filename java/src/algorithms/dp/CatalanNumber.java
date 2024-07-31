package algorithms.dp;

/**
 * Catalan numbers are defined as a mathematical sequence that consists of positive integers,
 * which can be used to find the number of possibilities of various combinations.
 * Cn = (2n)! / ((n + 1)! * n!)
 * The first few Catalan numbers for n = 0, 1, 2, 3, … are : 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, …
 * **/

public class CatalanNumber {

    public static void main(String[] args) {
        System.out.println(nthCatalanNumberRec(5));
        System.out.println(nthCatalanNumber(5));

        System.out.println(nthCatalanNumberRec(8));
        System.out.println(nthCatalanNumber(8));
    }

    // Time complexity: O(2^n)
    // Space complexity: O(n)
    public static int nthCatalanNumberRec(int n) {
        if (n <= 1)
            return 1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += nthCatalanNumberRec(i) * nthCatalanNumberRec(n - i - 1);
        }
        return res;
    }

    public static int nthCatalanNumber(int n) {
        int[] catalan = new int[n + 2];
        catalan[0] = 1;
        catalan[1] = 1;
        for(int i=2; i<=n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[n];
    }
}
