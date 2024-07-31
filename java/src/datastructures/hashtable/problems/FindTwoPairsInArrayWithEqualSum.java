package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class FindTwoPairsInArrayWithEqualSum {

    public static void main(String[] args) {
        int[] arr = {3, 4, 7, 1, 2, 9, 8};
        findPairsWithEqualSum(arr);
    }

    private static void findPairsWithEqualSum(int[] arr) {
        int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int sum = arr[i] + arr[j];
                if (map.containsKey(sum)) {
                    int[] prev = map.get(sum);
                    System.out.println("Pairs with equal sum: (" + prev[0] + ", " + prev[1] + ") and (" + arr[i] + ", " + arr[j] + ")");
                } else {
                    map.put(sum, new int[]{arr[i], arr[j]});
                }
            }
        }
    }
}
