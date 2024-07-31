package datastructures.string;

import java.util.PriorityQueue;

public class RearrangeAdjacentNotSame {

    static class Key {
        char ch;
        int freq;

        Key(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    // Using PriorityQueue - Greedy Algorithm
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public static String rearrangeString(String str) {
        int[] count = new int[26];
        PriorityQueue<Key> pq = new PriorityQueue<>((k1, k2) -> k2.freq - k1.freq);

        for(char c : str.toCharArray())
            count[c - 'a']++;

        for(int i = 0; i < 26; i++) {
            Key k = new Key((char)('a' + i), count[i]);
            if(k.freq > 0)
                pq.add(k);
        }
        StringBuilder sb = new StringBuilder();
        Key prev = new Key('#', -1);
        while(!pq.isEmpty()) {
            Key k = pq.poll();
            sb.append(k.ch);
            if(prev.freq > 0)
                pq.add(prev);
            k.freq--;
            prev = k;
        }
        if(sb.length() != str.length())
            return "Not possible";
        return sb.toString();
    }

    // Using Array - Greedy Algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static String rearrangeStringOptimized(String str) {
        int n = str.length();
        int[] count = new int[26];
        for(char c : str.toCharArray())
            count[c - 'a']++;
        int maxFreq = 0;
        char maxChar = 'a';
        for(int i = 0; i < 26; i++) {
            if(count[i] > maxFreq) {
                maxFreq = count[i];
                maxChar = (char)('a' + i);
            }
        }
        if(maxFreq > (n + 1) / 2)
            return "Not possible";
        char[] res = new char[n];
        int index = 0;

        // filling the most frequently occurring char in the
        // even indices
        while(count[maxChar - 'a'] > 0) {
            res[index] = maxChar;
            count[maxChar - 'a']--;
            index += 2;
        }

        // filling the remaining characters
        for(int i = 0; i < 26; i++) {
            while(count[i] > 0) {
                if(index >= n)
                    index = 1;
                res[index] = (char)('a' + i);
                index += 2;
                count[i]--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String str = "aaabc";
        System.out.println(rearrangeString(str));
        System.out.println(rearrangeStringOptimized(str));
        String str2 = "aaaabb";
        System.out.println(rearrangeString(str2));
        System.out.println(rearrangeStringOptimized(str2));
    }
}
