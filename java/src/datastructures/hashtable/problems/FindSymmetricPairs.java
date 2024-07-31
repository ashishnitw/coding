package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class FindSymmetricPairs {

    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        findSymmetric(arr);
    }

    private static void findSymmetric(int[][] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] pair : arr) {
            int first = pair[0];
            int second = pair[1];
            Integer value = map.get(second);

            if (value != null && value == first)
                System.out.println("Symmetric pair: " + second + ", " + first);
            else
                map.put(first, second);

        }
    }
}
