package algorithms.bit.basics;

public class Basics {

    public static void main(String[] args) {

        int a = 5;  // 101
        int b = 6;  // 110

        System.out.println(a << 1); // 1010 = 10
        System.out.println(a >> 1); // 10 = 2
        System.out.println(a & b);  // 100 = 4
        System.out.println(a | b);  // 111 = 7
        System.out.println(a ^ b);  // 011 = 3
    }
}
