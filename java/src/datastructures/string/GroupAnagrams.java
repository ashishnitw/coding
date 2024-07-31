package datastructures.string;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagramsUsingHashMap(words);
    }

    private static void groupAnagramsUsingHashMap(String[] words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String sortedWord = new String(arr);
            if (map.containsKey(sortedWord)) {
                List<String> list = map.get(sortedWord);
                list.add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(sortedWord, list);
            }
        }
        System.out.println(map.values());
    }

    private static void groupAnagrams(String[] words) {

    }
}
