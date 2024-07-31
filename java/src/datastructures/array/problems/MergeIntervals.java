package datastructures.array.problems;

import java.util.*;

public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] res = mergeIntervals(intervals);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0])); // Sort by start time
        int[] curr = intervals[0];
        merged.add(curr);
        for (int[] interval : intervals) {
            if (interval[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                curr = interval;
                merged.add(curr);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
