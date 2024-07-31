package algorithms.recursion;

public class ConvertIntegerToBinary {

    public static String convertToBinaryStr(int n) {
        if (n == 0)
            return "0";
        return convertToBinaryStr(n / 2) + n % 2;
    }

    public static int convertToBinaryInt(int n) {
        if (n == 0)
            return 0;
        return convertToBinaryInt(n / 2) * 10 + n % 2;
    }

    public static void main(String[] args) {
        System.out.println(convertToBinaryInt(10));
        System.out.println(convertToBinaryStr(10));
    }
}
