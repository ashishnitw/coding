package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingIntegerInArray {
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4};
        System.out.println(findFirstNonRepeatingInteger(arr));  // 6
    }

    private static int findFirstNonRepeatingInteger(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : arr) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for(int i : arr) {
            if(count.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
