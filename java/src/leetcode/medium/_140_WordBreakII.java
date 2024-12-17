package leetcode.medium;

import java.util.*;

public class _140_WordBreakII {

    public static List<String> wordBreakBacktrack(String s, List<String> dict) {
        Set<String> wordSet = new HashSet<>(dict);
        return backtrack(s, wordSet);
    }

    public static List<String> backtrack(String s, Set<String> wordSet) {
        List<String> result = new ArrayList<>();

        //Base case
        if (s.isEmpty())
            return result;

        if (wordSet.contains(s))
            result.add(s);

        for (int i=1; i<s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix)) {
                List<String> suffixBreaks = backtrack(suffix, wordSet);
                for (String segment : suffixBreaks) {
                    result.add(prefix + " " + segment);
                }
            }
        }
        return result;
    }

    public static List<String> wordBreakRecursiveMemo(String s, List<String> dict) {
        Set<String> wordSet = new HashSet<>(dict);
        Map<String, List<String>> memo = new HashMap<>(); // Memoization map to store results for substrings
        return backtrackMemo(s, wordSet, memo);
    }

    public static List<String> backtrackMemo(String s, Set<String> wordSet, Map<String, List<String>> memo) {

        if (memo.containsKey(s))
            return memo.get(s);

        List<String> result = new ArrayList<>();

        //Base case
        if (s.isEmpty())
            return result;

        if (wordSet.contains(s))
            result.add(s);

        for (int i=1; i<s.length(); i++) {
            String prefix = s.substring(0, i);
            String suffix = s.substring(i);
            if (wordSet.contains(prefix)) {
                List<String> suffixBreaks = backtrack(suffix, wordSet);
                for (String segment : suffixBreaks) {
                    result.add(prefix + " " + segment);
                }
            }
        }
        memo.put(s, result);
        return result;
    }

    public static List<String> wordBreakDP(String s, List<String> dict) {
        Set<String> wordSet = new HashSet<>(dict);
        int n = s.length();
        List<List<String>> dp = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dp.add(new ArrayList<>());
        }
        // Base case: empty string
        dp.get(0).add("");
        for(int i=1; i<=n; i++) {
            for(int j=0; j<i; j++) {
                String word = s.substring(j, i);
                if (wordSet.contains(word)) {
                    for (String sentence : dp.get(j)) {
                        if(sentence.isEmpty())
                            dp.get(i).add(word);
                        else
                            dp.get(i).add(sentence + " " + word);
                    }
                }
            }
        }
        return dp.get(n);
    }

    public static void main(String[] args) {
        System.out.println(wordBreakBacktrack("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
        System.out.println(wordBreakRecursiveMemo("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
        System.out.println(wordBreakDP("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));

        System.out.println(wordBreakBacktrack("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
        System.out.println(wordBreakRecursiveMemo("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
        System.out.println(wordBreakDP("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));

        System.out.println(wordBreakBacktrack("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println(wordBreakRecursiveMemo("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
        System.out.println(wordBreakDP("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }
}
