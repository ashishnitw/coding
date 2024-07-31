package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CountAllPathsBetween2Vertices {

    private int V;
    private List<Integer>[] adj;

    public CountAllPathsBetween2Vertices(int v) {
        this.V = v;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    // Time Complexity:
    private int countPaths(int u, int v) {
        boolean[] visited = new boolean[V];
        return countPathsUtil(u, v, visited);
    }

    private int countPathsUtil(int u, int v, boolean[] visited) {
        if (u == v)
            return 1;

        visited[u] = true;
        int count = 0;
        for (int i : adj[u]) {
            if (!visited[i]) {
                count += countPathsUtil(i, v, visited);
            }
        }
        visited[u] = false;
        return count;
    }


    public static void main(String[] args) {
        CountAllPathsBetween2Vertices graph = new CountAllPathsBetween2Vertices(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        System.out.println(graph.countPaths(0, 3));

    }
}
