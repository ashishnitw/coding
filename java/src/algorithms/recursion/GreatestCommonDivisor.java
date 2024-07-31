package algorithms.recursion;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(gcd(10, 15));
        System.out.println(gcd(35, 10));
        System.out.println(gcd(31, 2));
        System.out.println(gcd(31, 0));
        System.out.println(gcd(0, 10));
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
