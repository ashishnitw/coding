package datastructures.string;

public class FindExtraCharacterBetweenStrings {

    public static char extraCharUsingBit(String a, String b) {
        int res = 0;
        for(char i : a.toCharArray())
            res ^= i;
        for(char i : b.toCharArray())
            res ^= i;
        return (char)res;
    }

    public static char extraCharUsingCharCode(String a, String b) {
        int i = 0;
        int sumA = 0, sumB = 0;
        for (; i < a.length(); i++) {
            sumA += a.charAt(i);
            sumB += b.charAt(i);
        }
        sumB += b.charAt(i);
        return (char)(sumB - sumA);
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cbdae";
        System.out.println(extraCharUsingBit(a, b));
        System.out.println(extraCharUsingCharCode(a, b));
    }
}
