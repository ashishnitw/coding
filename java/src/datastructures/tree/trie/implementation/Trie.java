package datastructures.tree.trie.implementation;

import java.util.Arrays;

public class Trie {
    public static class TrieNode {
        public TrieNode[] children;
        public boolean isEndOfWord; // true if the node represents the end of word

        public TrieNode() {
            children = new TrieNode[26];    // a-z
            isEndOfWord = false;
        }

        public void markAsLeaf() {
            isEndOfWord = true;
        }

        public void unMarkAsLeaf() {
            isEndOfWord = false;
        }
    }

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String key) {
        if (key == null || key.isEmpty()) {
            System.out.println("Null key can't be inserted into trie");
            return;
        }
        key = key.toLowerCase();
        TrieNode curr = root;
        // TODO
    }

    public boolean search(String key) {
        // TODO
        return true;
    }

    public boolean delete(String key) {
        // TODO
        return true;
    }

    public static void main(String[] args) {
        String keys[] = {"the", "a", "there", "answer", "any", "by", "bye", "their","abc"};
        Trie trie = new Trie();
        System.out.println("Keys: " + Arrays.toString(keys));
        System.out.println("Inserting keys into trie...");
        for (String key : keys) {
            trie.insert(key);
            System.out.println(key + " inserted");
        }
    }

}
