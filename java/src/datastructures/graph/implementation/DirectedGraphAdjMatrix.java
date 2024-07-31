package datastructures.graph.implementation;

public class DirectedGraphAdjMatrix {
    private int V;  // No. of vertices
    private int[][] adj; // Adjacency Matrix

    public DirectedGraphAdjMatrix(int vertices) {
        V = vertices;
        adj = new int[V][V];
    }

    public void addEdge(int v, int w) { // v = source, w = destination
        adj[v][w] = 1;
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraphAdjMatrix g = new DirectedGraphAdjMatrix(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        System.out.println("Graph created");
        g.printGraph();
    }
}
