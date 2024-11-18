package algorithms.bit.problems;

public class CountBits {

    public static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1; // n & 1 will give 1 if last bit is 1 else 0
            n >>= 1;
        }
        return count;
    }

    /** Brian Kernighan's algorithm */
    public static int countBits2(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1); // n & (n-1) will remove the last set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5)); // 2
        System.out.println(countBits(6)); // 2
        System.out.println(countBits(7)); // 3
        System.out.println(countBits(0)); // 0

        System.out.println(countBits2(5)); // 2
        System.out.println(countBits2(6)); // 2
        System.out.println(countBits2(7)); // 3
        System.out.println(countBits2(0)); // 0

    }
}
