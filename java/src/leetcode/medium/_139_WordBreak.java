package leetcode.medium;

import java.util.*;

public class _139_WordBreak {

    // n = length of s
    // m = no. of words in dictionary
    // Time: O(2^n)
    // Space: O(n), due to the recursion stack.
    public static boolean wordBreakRec(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return canSegment(s, wordSet);
    }

    private static boolean canSegment(String s, Set<String> wordSet) {
        // Base case: if the string is empty, we can segment it
        if (s.isEmpty())
            return true;
        // Try all prefixes of the string
        for (int i=1; i<=s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if(wordSet.contains(prefix) && canSegment(suffix, wordSet)) {
                return true;
            }
        }
        // If no valid segmentation is found, return false
        return false;
    }

    public static boolean wordBreakMemoization(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        // Use a HashMap for memoization
        Map<String, Boolean> memo = new HashMap<>();
        return wordBreakMemoizationUtil(s, wordSet, memo);
    }

    private static boolean wordBreakMemoizationUtil(String s, Set<String> wordSet, Map<String, Boolean> memo) {
        if (s.isEmpty())
            return true;
        if (memo.containsKey(s))
            return memo.get(s);
        for(int i=1; i<=s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix) && wordBreakMemoizationUtil(suffix, wordSet, memo)) {
                memo.put(s, true);
                return true;
            }
        }
        return false;
    }

    // Time: O(n^2)
    public static boolean wordBreakDP(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        // Create a DP array to store if the substring s[0:i] can be segmented
        // dp[i] = true means that the substring s[0:i-1] can be segmented into words from the dictionary.
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    // Time: O(n^2)
    // Space:
    public static boolean wordBreakDPOptimized(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSet = new HashSet<>(wordDict);
        // Create a DP array to store if the substring s[0:i] can be segmented
        // dp[i] = true means that the substring s[0:i-1] can be segmented into words from the dictionary.
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        // Test Case
        System.out.println(wordBreakRec("leetcode", Arrays.asList("leet", "code"))); // Output: true
        System.out.println(wordBreakMemoization("leetcode", Arrays.asList("leet", "code"))); // Output: true
        System.out.println(wordBreakDP("leetcode", Arrays.asList("leet", "code"))); // Output: true
        System.out.println(wordBreakDPOptimized("leetcode", Arrays.asList("leet", "code"))); // Output: true

        System.out.println(wordBreakRec("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // Output: false
        System.out.println(wordBreakMemoization("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // Output: false
        System.out.println(wordBreakDP("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // Output: false
        System.out.println(wordBreakDPOptimized("catsandog", Arrays.asList("cats","dog","sand","and","cat"))); // Output: false
    }
}
