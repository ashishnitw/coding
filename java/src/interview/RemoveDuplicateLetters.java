package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/remove-duplicate-letters/
 * */
public class RemoveDuplicateLetters {
    public String removeDuplicates(String s) {

        int n = s.length();

        // Find the last occurrence of each character
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            last.put(s.charAt(i), i);

        // Use a stack to keep the characters
        Stack<Character> stack = new Stack<>();

        // Use a boolean array to keep track of characters in the stack
        boolean[] inStack = new boolean[26];

        for (int i=0; i<n; i++) {
            char c = s.charAt(i);

            // If the character is already in the stack, skip it
            if (inStack[c - 'a'])
                continue;

            // If the character is smaller than the top of the stack and the top of the stack
            // will occur later in the string, pop the top of the stack
            while (!stack.isEmpty() && c < stack.peek() && last.get(stack.peek()) > i) {
                char top = stack.pop();
                inStack[top - 'a'] = false;
            }
            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        System.out.println(removeDuplicateLetters.removeDuplicates("bcabc")); // abc
        System.out.println(removeDuplicateLetters.removeDuplicates("cbacdcbc")); // acdb
    }
}
