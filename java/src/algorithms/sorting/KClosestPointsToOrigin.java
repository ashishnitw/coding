package algorithms.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        System.out.println(Arrays.toString(kClosest(points, 1)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> distance(a).compareTo(distance(b)));
        for (int[] point : points) {
            q.add(point);
            if (q.size() > k)
                q.poll();
        }
        int[][] res = new int[k][2];
        int i = 0;
        while (!q.isEmpty()) {
            res[i++] = q.poll();
        }
        return res;
    }

    public static Double distance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}
