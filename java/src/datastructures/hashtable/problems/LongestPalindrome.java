package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        boolean isOdd = false;
        int res = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> e : map.entrySet() ) {
            int val = e.getValue();
            if (val % 2 == 0) {
                res += val;
            } else {
                isOdd = true;
                res += val - 1;
            }
        }
        if (isOdd)
            res++;
        return res;
    }
}
