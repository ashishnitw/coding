package algorithms.recursion;

public class ExponentOfNumber {

    public static int power(int base, int exp) {
        if (exp == 0)
            return 1;
        return base * power(base, exp - 1);
    }

    public static void main(String[] args) {
        System.out.println("2^3 = " + power(2, 3));   // 8
        System.out.println("2^0 = " + power(2, 0));   // 1
    }
}
