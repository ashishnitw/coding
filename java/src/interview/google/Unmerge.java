package interview.google;

import java.util.*;

/**
 * Unmerge: given a character sequence, split it into two subsequences that are words in a dictionary, and that would merge into the original sequence.
 * (Solution usually involves recursion, with some pruning optimizations)
 * */
public class Unmerge {

    // n = length of s
    // Time: O(2^n)
    // Space: O(n), for the recursion stack (maximum depth of recursion). Additional space is used for StringBuilder and storing results.
    public static Set<Set<String>> unmergeBacktrack(String s, Set<String> dictionary) {
        Set<Set<String>> result = new HashSet<>();
        backtrack(s, 0, new StringBuilder(), new StringBuilder(), dictionary, result);
        return result;
    }

    private static void backtrack(String s, int index, StringBuilder word1, StringBuilder word2, Set<String> dictionary, Set<Set<String>> result) {
        // Base case: If the entire sequence is processed
        if (index == s.length()) {
            String s1 = word1.toString();
            String s2 = word2.toString();
            if (dictionary.contains(s1) && dictionary.contains(s2)) {
                result.add(new HashSet<>(Arrays.asList(s1, s2)));
            }
            return;
        }

        // Add the current character to the first word and recurse
        word1.append(s.charAt(index));
        backtrack(s, index + 1, word1, word2, dictionary, result);
        word1.deleteCharAt(word1.length() - 1);

        // Add the current character to the second word and recurse
        word2.append(s.charAt(index));
        backtrack(s, index + 1, word1, word2, dictionary, result);
        word2.deleteCharAt(word2.length() - 1);
    }

    /**
     *  n = length of s
     *  k = average length of words in the dictionary
     *  d = dictionary size
     *  Time: O(2^n * k * d), Pruning significantly reduces the number of recursive calls by avoiding invalid paths.
     *  Space: O(n)
     * */
    public static Set<Set<String>> unmergeBacktrackWithPrefixCheck(String s, Set<String> dictionary) {
        Set<Set<String>> result = new HashSet<>();
        backtrackWithPrefixCheck(s, 0, new StringBuilder(), new StringBuilder(), dictionary, result);
        return result;
    }

    private static void backtrackWithPrefixCheck(String s, int index, StringBuilder word1, StringBuilder word2, Set<String> dictionary, Set<Set<String>> result) {
        // Base case: If the entire sequence is processed
        if (index == s.length()) {
            String s1 = word1.toString();
            String s2 = word2.toString();
            if (dictionary.contains(s1) && dictionary.contains(s2)) {
                result.add(new HashSet<>(Arrays.asList(s1, s2)));
            }
            return;
        }

        // Add the current character to the first word and recurse
        word1.append(s.charAt(index));
        if (canForm(word1.toString(), dictionary)) { // Pruning step
            backtrack(s, index + 1, word1, word2, dictionary, result);
        }
        word1.deleteCharAt(word1.length() - 1);

        // Add the current character to the second word and recurse
        word2.append(s.charAt(index));
        if (canForm(word2.toString(), dictionary)) { // Pruning step
            backtrack(s, index + 1, word1, word2, dictionary, result);
        }
        word2.deleteCharAt(word2.length() - 1);
    }

    // Check if a prefix could potentially lead to a valid word in the dictionary
    private static boolean canForm(String prefix, Set<String> dictionary) {
        for(String word : dictionary) {
            if (word.startsWith(prefix))
                return true;
        }
        return false;
    }

    /**
     * ====> USING TRIE <====
     n = length of s
     m = average length of words in the dictionary
     k = dictionary size
     Time: O(2^n * m)
     O(m * k) = Building trie
     O(length of prefix) = check if a string is a prefix of any word in the dictionary
     Space: O(n + m * k), where k is the number of words and m is the average length.
     */
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        // Insert a word into the Trie
        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        // Check if a string is a valid word
        boolean isWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.children.containsKey(c))
                    return false;
                node = node.children.get(c);
            }
            return node.isWord;
        }

        // Check if a string is a prefix of any word
        boolean isPrefix(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.children.containsKey(c))
                    return false;
                node = node.children.get(c);
            }
            return true;
        }
    }

    public static Set<Set<String>> unmergeBacktrackUsingTrie(String s, Set<String> dictionary) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        Set<Set<String>> result = new HashSet<>();
        backtrackUsingTrie(s, 0, new StringBuilder(), new StringBuilder(), trie, result);
        return result;
    }

    private static void backtrackUsingTrie(String s, int index, StringBuilder word1, StringBuilder word2, Trie trie, Set<Set<String>> result) {
        if (s.length() == index) {
            String s1 = word1.toString();
            String s2 = word2.toString();
            if (trie.isWord(s1) && trie.isWord(s2))
                result.add(new HashSet<>(Arrays.asList(s1, s2)));
            return;
        }
        char currentChar = s.charAt(index);

        word1.append(currentChar);
        if (trie.isPrefix(word1.toString()))
            backtrackUsingTrie(s, index + 1, word1, word2, trie, result);
        word1.deleteCharAt(word1.length() - 1);

        word2.append(currentChar);
        if (trie.isPrefix(word2.toString()))
            backtrackUsingTrie(s, index + 1, word1, word2, trie, result);
        word2.deleteCharAt(word2.length() - 1);
    }

    public static List<String> unmergeUsingTrieAndMemoization(String sequence, Set<String> wordDict) {
        Trie trie = new Trie();

        // Insert all words into the Trie
        for (String word : wordDict) {
            trie.insert(word);
        }

        // Memoization map
        Map<Integer, List<String>> memo = new HashMap<>();

        // Start recursive backtracking
        return backtrackUsingTrieAndMemoization(sequence, 0, new StringBuilder(), new StringBuilder(), trie, memo);
    }

    private static List<String> backtrackUsingTrieAndMemoization(String sequence, int index, StringBuilder word1, StringBuilder word2, Trie trie, Map<Integer, List<String>> memo) {
        // Check if this index is already computed
        if (memo.containsKey(index) && !memo.get(index).isEmpty()) {
            return memo.get(index);
        }

        // Base case: if we've processed the entire sequence
        if (index == sequence.length()) {
            String str1 = word1.toString();
            String str2 = word2.toString();
            if (trie.isWord(str1) && trie.isWord(str2)) {
                return Arrays.asList(str1, str2);
            }
            return new ArrayList<>();
        }

        // Get the current character
        char currentChar = sequence.charAt(index);

        // Explore by adding the current character to word1
        word1.append(currentChar);
        List<String> result = new ArrayList<>();
        if (trie.isPrefix(word1.toString())) { // Only continue if word1 is a valid prefix
            result = backtrackUsingTrieAndMemoization(sequence, index + 1, word1, word2, trie, memo);
        }
        if (!result.isEmpty()) {
            memo.put(index, result);
            return result; // Stop if a result is found
        }
        word1.deleteCharAt(word1.length() - 1); // Backtrack

        // Explore by adding the current character to word2
        word2.append(currentChar);
        if (trie.isPrefix(word2.toString())) { // Only continue if word2 is a valid prefix
            result = backtrackUsingTrieAndMemoization(sequence, index + 1, word1, word2, trie, memo);
        }
        if (!result.isEmpty()) {
            memo.put(index, result);
            return result; // Stop if a result is found
        }
        word2.deleteCharAt(word2.length() - 1); // Backtrack

        // If no valid result is found
        memo.put(index, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(unmergeBacktrack("catsdog", Set.of("cat", "dog", "cats")));
        System.out.println(unmergeBacktrack("pineapple", Set.of("pine", "apple", "pen", "pineapple")));
        System.out.println(unmergeBacktrack("abcd", Set.of("a", "b", "c", "d", "ab", "cd")));
        System.out.println(unmergeBacktrack("hellohello", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrack("ohellohell", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrack("test", Set.of("test", "hello")));

        System.out.println(unmergeBacktrackWithPrefixCheck("catsdog", Set.of("cat", "dog", "cats")));
        System.out.println(unmergeBacktrackWithPrefixCheck("pineapple", Set.of("pine", "apple", "pen", "pineapple")));
        System.out.println(unmergeBacktrackWithPrefixCheck("abcd", Set.of("a", "b", "c", "d", "ab", "cd")));
        System.out.println(unmergeBacktrackWithPrefixCheck("hellohello", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrackWithPrefixCheck("ohellohell", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrackWithPrefixCheck("test", Set.of("test", "hello")));

        System.out.println(unmergeBacktrackUsingTrie("catsdog", Set.of("cat", "dog", "cats")));
        System.out.println(unmergeBacktrackUsingTrie("pineapple", Set.of("pine", "apple", "pen", "pineapple")));
        System.out.println(unmergeBacktrackUsingTrie("abcd", Set.of("a", "b", "c", "d", "ab", "cd")));
        System.out.println(unmergeBacktrackUsingTrie("hellohello", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrackUsingTrie("ohellohell", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeBacktrackUsingTrie("test", Set.of("test", "hello")));

        System.out.println(unmergeUsingTrieAndMemoization("catsdog", Set.of("cat", "dog", "cats")));
        System.out.println(unmergeUsingTrieAndMemoization("pineapple", Set.of("pine", "apple", "pen", "pineapple")));
        System.out.println(unmergeUsingTrieAndMemoization("abcd", Set.of("a", "b", "c", "d", "ab", "cd")));
        System.out.println(unmergeUsingTrieAndMemoization("hellohello", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeUsingTrieAndMemoization("ohellohell", Set.of("hello", "hel", "lo")));
        System.out.println(unmergeUsingTrieAndMemoization("test", Set.of("test", "hello")));
    }
}
