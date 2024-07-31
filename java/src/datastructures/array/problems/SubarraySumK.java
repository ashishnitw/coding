package datastructures.array.problems;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(subarraySum(arr, 9));    // 2
    }

    private static int subarraySum(int[] arr, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            sum += i;
            if (sum == k) {
                count++;
            }
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
