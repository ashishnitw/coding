package datastructures.hashtable.problems;

import java.util.HashSet;
import java.util.Set;

public class FindTwoNumbersWithSumK {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println(findPairWithSumK(arr1, 7));
        System.out.println(findPairWithSumK(arr1, 12));
    }

    private static boolean findPairWithSumK(int[] arr1, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr1) {
            if(set.contains(k - i))
                return true;
            else
                set.add(i);
        }
        return false;
    }
}
