package algorithms.recursion;

public class ModuloOperation {

    public static int mod(int dividend, int divisor) {
        if (divisor == 0)
            throw new IllegalArgumentException("Divisor cannot be 0");
        if (dividend < divisor)
            return dividend;
        return mod(dividend - divisor, divisor);
    }

    public static void main(String[] args) {
        System.out.println(mod(10, 3));   // 1
        System.out.println(mod(10, 2));   // 0
    }
}
