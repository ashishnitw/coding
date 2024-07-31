package datastructures.string;

public class ChangeToNewCharacterSet {
    public static void main(String[] args) {
        String charSet = "qwertyuiopasdfghjklzxcvbnm";
        String str = "egrt";
        //System.out.println(convertUsingHashing(charSet, str));
        System.out.println(convert(charSet, str));
    }

    private static String convert(String charSet, String s) {
        StringBuilder sb = new StringBuilder();
        char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (char i : s.toCharArray()) {
            int index = charSet.indexOf(i);
            sb.append(alphabets[index]);
        }
        return sb.toString();
    }

    public static String convertUsingHashing(String charSet, String s) {
        int n = s.length();
        char[] alphabets = charSet.toCharArray();
        char[] hashChar = new char[26];
        for (int i = 0; i < 26; i++) {
            hashChar[Math.abs(alphabets[i] - 'a')] = (char) ('a' + i);
        }
        String str = "";
        for (int i = 0; i < n; i++) {
            s += hashChar[Math.abs(str.charAt(i) - 'a')];
        }
        return str;
    }

}
