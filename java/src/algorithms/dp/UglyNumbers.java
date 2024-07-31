package algorithms.dp;

public class UglyNumbers {
    public static void main(String[] args) {
        int n = 150;
        System.out.println(n + "th Ugly number is: " + nthUgly(n));
        System.out.println(n + "th Ugly number Using DP is: " + nthUglyDP(n));
    }

    private static int nthUgly(int n) {
        long startTime = System.nanoTime();
        int i = 1;
        int count = 1;
        while(count < n) {
            i++;
            if(isUgly(i)) {
                count++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000 + " ms");
        return i;
    }
    private static boolean isUgly(int n) {
        n = maxDivide(n, 2);
        n = maxDivide(n, 3);
        n = maxDivide(n, 5);
        return n == 1 ? true : false;
    }
    private static int maxDivide(int n, int i) {
        while(n%i == 0) {
            n = n/i;
        }
        return n;
    }

    public static int nthUglyDP(int n) {
        long startTime = System.nanoTime();
        int[] ugly = new int[n];  // To store ugly numbers
        int i2 = 0, i3 = 0, i5 = 0;
        int next_multiple_of_2 = 2;
        int next_multiple_of_3 = 3;
        int next_multiple_of_5 = 5;
        int next_ugly_no = 1;

        ugly[0] = 1;
        for(int i = 1; i < n; i++) {
            next_ugly_no = Math.min(next_multiple_of_2, Math.min(next_multiple_of_3, next_multiple_of_5));
            ugly[i] = next_ugly_no;
            if (next_ugly_no == next_multiple_of_2) {
                i2++;
                next_multiple_of_2 = ugly[i2]*2;
            }
            if (next_ugly_no == next_multiple_of_3) {
                i3++;
                next_multiple_of_3 = ugly[i3]*3;
            }
            if (next_ugly_no == next_multiple_of_5) {
                i5++;
                next_multiple_of_5 = ugly[i5]*5;
            }
        }
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime)/1000 + " ms");
        return next_ugly_no;
    }
}
