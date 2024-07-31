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

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> curr, int[] nums, int idx) {
        res.add(new ArrayList<>(curr));  // Add the current subset to the result
        for (int i = idx; i < nums.length; i++) {
            curr.add(nums[i]);
            System.out.println("Added: " + nums[i] + " -> " + curr);
            backtrack(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
            System.out.println("Removed: " + nums[i] + " -> " + curr);
        }
    }
}
