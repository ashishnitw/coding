package datastructures.graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class IsBipartiteGraph {

    public static void main(String[] args) {
        int[][] graph = {{1, 3}, {0, 2}, {1, 3}, {0, 2}};
        System.out.println(isBipartite(graph));
        int[][] graph1 = {{1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2}};
        System.out.println(isBipartite(graph1));
    }

    private static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];   // 0: uncolored, 1: blue, -1: red
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                if (!bfs(graph, color, i))
                    return false;
            }
        }
        return true;
    }

    private static boolean bfs(int[][] graph, int[] color, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        color[i] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int x : graph[curr]) {
                if (color[x] == 0) {
                    color[x] = -color[curr];
                    queue.add(x);
                } else if (color[x] == color[curr]) {
                    return false;
                }
            }
        }
        return true;
    }
}
