package algorithms.recursion;

public class CountNumberOfDigitsNumber {

    public static int count(int n) {
        if (n == 0)
            return 0;
        return 1 + count(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(count(12345));   // 5
        System.out.println(count(0));   // 0
    }
}
