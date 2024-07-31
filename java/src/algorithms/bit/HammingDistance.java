package algorithms.bit;

public class HammingDistance {
    public static void main(String[] args) {
        System.out.println("Hamming Distance = " + hammingDistance(1, 4));
    }

    private static int hammingDistance(int a, int b) {
        return Integer.bitCount(a ^ b);
    }
}
