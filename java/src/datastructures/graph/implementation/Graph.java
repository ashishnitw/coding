package datastructures.graph.implementation;

public class Graph {
    private int V;  // Number of vertices
    private int E;  // Number of edges
    private int[][] adj;

    public Graph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        adj[u][v] = 1;
    }
}
