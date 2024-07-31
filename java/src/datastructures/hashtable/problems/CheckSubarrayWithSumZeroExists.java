package datastructures.hashtable.problems;

import java.util.HashMap;
import java.util.Map;

public class CheckSubarrayWithSumZeroExists {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, -2, -2, 5, -4, 3};
        System.out.println(sumZeroExist(arr1));  // true
        int[] arr2 = {1, 4, 2, 5, -4, 3};
        System.out.println(sumZeroExist(arr2));  // false
    }

    private static boolean sumZeroExist(int[] arr) {
        // Use HashMap to store Sum as key and index i as value till sum has been calculated.
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0; i<n; i++) {
            sum += arr[i];
            if(sum == 0 || map.containsKey(sum) || arr[i] == 0)
                return true;
            map.put(sum, i);
        }
        return false;
    }
}
