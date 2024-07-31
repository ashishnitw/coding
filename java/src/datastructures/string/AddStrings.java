package datastructures.string;

public class AddStrings {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println("Sum of two numbers: " + sum(num1, num2));
    }

    public static String sum(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            if(i >= 0)
                carry += num1.charAt(i--) - '0';
            if(j >= 0)
                carry += num2.charAt(j--) - '0';
            int value = carry % 10;
            carry = carry / 10;
            res.append(value);
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }
}
