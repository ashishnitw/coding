package algorithms.recursion;

public class CheckPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null)
            return false;
        return isPalindromeUtil(s, 0, s.length() - 1);
    }

    public static boolean isPalindromeUtil(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j))
            return false;
        if (i >= j)
            return true;
        return isPalindromeUtil(s, i + 1, j - 1);
    }

    public static boolean isPalindrome(int[] s, int i, int j) {
        if (s == null)
            return false;
        return isPalindromeUtil(s, i, j);
    }

    public static boolean isPalindromeUtil(int[] s, int i, int j) {
        if (s[i] != s[j])
            return false;
        if (i >= j)
            return true;
        return isPalindromeUtil(s, i + 1, j - 1);
    }

    public static void main(String[] args) {
        System.out.println("Is 'racecar' a palindrome? " + isPalindrome("racecar"));
        System.out.println("Is 'hello' a palindrome? " + isPalindrome("hello"));

        int[] arr = {1, 2, 3, 2, 1};
        System.out.println("Is [1, 2, 3, 2, 1] a palindrome? " + isPalindrome(arr, 0, arr.length - 1));
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Is [1, 2, 3, 4, 5] a palindrome? " + isPalindrome(arr2, 0, arr2.length - 1));
    }
}
