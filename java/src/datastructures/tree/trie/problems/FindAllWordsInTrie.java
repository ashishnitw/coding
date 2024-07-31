package datastructures.tree.trie.problems;

import datastructures.tree.trie.implementation.Trie;
import datastructures.tree.trie.implementation.Trie.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllWordsInTrie {

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};
        Trie trie = new Trie();
        for (String key : keys) {
            trie.insert(key);
            System.out.println("inserted: " + key);
        }

        List<String> words = findAllWords(trie.root);
        System.out.println("Words in the trie: " + words);
    }

    public static List<String> findAllWords(TrieNode root) {
        List<String> result = new ArrayList<>();
        getWords(root, result, 0);
        return result;
    }

    public static void getWords(TrieNode root, List<String> result, int level) {
        if (root == null)
            return;
        if (root.isEndOfWord)
            result.add(getWord(root, level));
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                getWords(root.children[i], result, level + 1);
            }
        }
        // TODO
    }

    private static String getWord(TrieNode root, int level) {
        System.out.println("level: " + level);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            for (int j = 0; j < 26; j++) {
                if (root.children[j] != null) {
                    sb.append((char) ('a' + j));
                    root = root.children[j];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
