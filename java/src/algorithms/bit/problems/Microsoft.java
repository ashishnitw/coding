package algorithms.bit.problems;

// Given two non-negative integers A and B find the number of bits set to 1 in binary representation of the number A*B.
public class Microsoft {

    public static int countBits(int A, int B) {
        return Integer.bitCount(A * B);
    }

    public static void main(String[] args) {
        System.out.println(countBits(3, 4)); // 2
    }
}
