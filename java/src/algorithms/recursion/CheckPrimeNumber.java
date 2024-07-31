package algorithms.recursion;

public class CheckPrimeNumber {

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        return isPrimeUtil(n, n/2);
    }

    private static boolean isPrimeUtil(int n, int i) {
        if (n < 2)
            return false;
        if (i == 1)
            return true;
        if (n % i == 0)
            return false;
        return isPrimeUtil(n, i - 1);
    }

    public static void main(String[] args) {
        System.out.println("Is 7 a prime number? " + isPrime(7));
        System.out.println("Is 10 a prime number? " + isPrime(10));
        System.out.println("Is 13 a prime number? " + isPrime(13));
        System.out.println("Is 15 a prime number? " + isPrime(15));
    }
}
