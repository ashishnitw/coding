package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Number of Subsets of an array of size N = 2^n
 * Proof: For each element of the array we have 2 choices:
 * Choice 1: Include it into the subset.
 * Choice 2: Exclude it from the subset.
 * */
public class Subsets {

    private static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), arr, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> curr, int[] arr, int idx) {
        res.add(new ArrayList<>(curr));  // Add the current subset to the result
        for (int i = idx; i < arr.length; i++) {
            curr.add(arr[i]);
            //System.out.println("Added: " + nums[i] + " -> " + curr);
            backtrack(res, curr, arr, i + 1);
            curr.remove(curr.size() - 1);
            //System.out.println("Removed: " + nums[i] + " -> " + curr);
        }
        System.out.println(curr);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }
}
