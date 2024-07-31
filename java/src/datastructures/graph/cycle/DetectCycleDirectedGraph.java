package datastructures.graph.cycle;

import java.util.ArrayList;
import java.util.List;

public class DetectCycleDirectedGraph {
    private int V;
    private List<Integer>[] adj;

    public DetectCycleDirectedGraph(int vertices) {
        V = vertices;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public boolean isCyclicUsingDfs() {
        boolean[] visited = new boolean[V];   // To keep track of visited nodes
        boolean[] recStack = new boolean[V];    // To keep track of nodes in recursion stack
        for (int i = 0; i < V; i++) {
            if (dfs(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfs(int v, boolean[] visited, boolean[] recStack) {
        if (recStack[v])
            return true;    // Cycle detected
        if (visited[v])
            return false;   // Already visited this node
        visited[v] = true;
        recStack[v] = true;
        List<Integer> adjList = adj[v];
        for (Integer node : adjList) {
            if (dfs(node, visited, recStack)) {
                return true;
            }
        }
        recStack[v] = false;
        return false;
    }

    public boolean isCyclicUsingColors() {
        int[] color = new int[V];
        for (int i = 0; i < V; i++) {
            if (color[i] == 0) {
                if (dfsColor(i, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfsColor(int i, int[] color) {
        if (color[i] == 1)
            return true;    // Cycle detected
        if (color[i] == 2)
            return false;   // Already visited this node
        color[i] = 1;
        List<Integer> adjList = adj[i];
        for (Integer node : adjList) {
            if (dfsColor(node, color)) {
                return true;
            }
        }
        color[i] = 2;
        return false;
    }

    public boolean isCyclicUsingTopologicalSort() {
        return false;
    }

    public boolean isCyclicUsingKahnAlgorithm() {
        return false;
    }

    public static void main(String[] args) {
        DetectCycleDirectedGraph g = new DetectCycleDirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.println("Graph created");
        System.out.println("Is cyclic using DFS: " + g.isCyclicUsingDfs());
        System.out.println("Is cyclic using Colors: " + g.isCyclicUsingColors());
        System.out.println("Is cyclic using Topological Sort: " + g.isCyclicUsingTopologicalSort());
        System.out.println("Is cyclic using Kahn Algorithm: " + g.isCyclicUsingKahnAlgorithm());
    }
}
