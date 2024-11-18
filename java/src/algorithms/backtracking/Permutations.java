package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> getPermutations(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), arr, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] arr, int i) {

    }

    public static void main(String[] args) {
        System.out.println(getPermutations(new int[]{1, 2, 3}));
    }
}
