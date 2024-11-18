package leetcode.premium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/employee-free-time/description/
 *
 * */
public class EmployeeFreeTime {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" + "start=" + start + ", end=" + end + "}";
        }
    }

    private static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        // Step 1: Collect all intervals from all employees
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> emp : schedule) {
            intervals.addAll(emp);
        }

        // Step 2: Sort the intervals by start time
        intervals.sort((a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

        // Step 3: Merge overlapping intervals
        List<Interval> merged = new ArrayList<>();
        Interval prev = intervals.get(0);
        for (int i=1; i< intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (prev.end < curr.start) {
                merged.add(prev);
                prev = curr;
            } else {
                prev.end = Math.max(prev.end, curr.end);
            }
        }
        merged.add(prev);

        // Step 4: Find the gaps between the merged intervals
        List<Interval> result = new ArrayList<>();
        for (int i=1; i<merged.size(); i++) {
            if (merged.get(i-1).end < merged.get(i).start) {
                result.add(new Interval(merged.get(i-1).end, merged.get(i).start));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Interval>> schedule = new ArrayList<>();
        List<Interval> emp1 = Arrays.asList(new Interval(1, 2), new Interval(5, 6));
        List<Interval> emp2 = List.of(new Interval(1, 3));
        List<Interval> emp3 = List.of(new Interval(4, 10));
        schedule.add(emp1);
        schedule.add(emp2);
        schedule.add(emp3);

        List<Interval> result = employeeFreeTime(schedule);
        System.out.println("Employee Free Time: " + result);
    }
}
