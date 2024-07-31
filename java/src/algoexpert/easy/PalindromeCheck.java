package algoexpert.easy;

public class PalindromeCheck {
    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdcba"));
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
