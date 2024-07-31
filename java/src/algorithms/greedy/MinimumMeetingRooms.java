package algorithms.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    public static int minRooms(int[][] meetings) {
//        int n = meetings.length;
//        if(n == 0) return 0;
//        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);   // Sort in ascending order by start time
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        pq.add(meetings[0][1]); // Add the end time of the first meeting
//        for(int i=1; i<n; i++) {
//            int start = meetings[i][0];
//            int end = meetings[i][1];
//            if(start >= pq.peek()) {
//                pq.poll();
//            }
//            pq.add(end);
//        }
//        return pq.size();
        return 0;
    }

    public static void main(String[] args) {
        int meetings[][] = {{ 0, 5 }, { 1, 2 }, { 5, 10 }};
        System.out.println(minRooms(meetings));
    }
}
