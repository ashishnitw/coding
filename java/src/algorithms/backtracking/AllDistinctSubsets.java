package algorithms.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllDistinctSubsets {

    public static void main(String[] args) {
        int[] nums = {2, 1, 2};
        List<List<Integer>> res = allDistinctSubsets(nums);
        System.out.println("All distinct subsets of the given array are: " + res.size());
        System.out.println(res);
    }

    private static List<List<Integer>> allDistinctSubsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, ArrayList<Integer> curr, int[] nums, int idx) {
        res.add(new ArrayList<>(curr));  // Add the current subset to the result
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            backtrack(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
