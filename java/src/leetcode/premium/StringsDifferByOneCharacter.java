package leetcode.premium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringsDifferByOneCharacter {

    public static boolean differByOne(List<String> list) {
        Set<String> set = new HashSet<>();
        for (String s : list) {
            for (int i=0; i<s.length(); i++) {
                String temp = s.substring(0,i) + "*" + s.substring(i+1);
                if (set.contains(temp))
                    return true;
                set.add(temp);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(differByOne(Arrays.asList("abcd", "acbd", "aacd"))); // true
        System.out.println(differByOne(Arrays.asList("ab", "cd", "yz")));       // false
    }
}
