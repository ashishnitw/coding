package datastructures.graph.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirectedGraph {
    private int V;
    private List<Integer>[] adj;

    public DetectCycleUndirectedGraph(int vertices) {
        V = vertices;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    private void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    private boolean isCyclicUndirected() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int v, boolean[] visited, int parent) {
        visited[v] = true;
        for (Integer node : adj[v]) {
            if (!visited[node]) {
                if (dfs(node, visited, v)) {
                    return true;
                }
            } else if (node != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUndirectedGraph graph = new DetectCycleUndirectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Check: " + graph.isCyclicUndirected());
    }
}
