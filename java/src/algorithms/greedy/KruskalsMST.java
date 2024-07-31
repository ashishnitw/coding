package algorithms.greedy;


import java.util.Arrays;

/**
 *  Kruskal's Minimum Spanning Tree Algorithm
 *  The following implementation assumes that the graph is represented using adjacency list representation.
 *  The input graph is a weighted graph and for every edge (u, v) in the graph, the weight of the edge is given.
 *  The graph is represented in the form of a list of edges.
 *  The graph is undirected.
 *  The graph is connected.
 * */
public class KruskalsMST {

    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void kruskals() {
        // Sort all the edges in non-decreasing order of their weight.
    }

    public static void main(String[] args) {
        int V = 4;  // Number of vertices in the graph
        int E = 5;  // Number of edges in the graph
        Edge[] edges = new Edge[E];
        edges[0] = new Edge(0, 1, 10);
        edges[1] = new Edge(0, 2, 6);
        edges[2] = new Edge(0, 3, 5);
        edges[3] = new Edge(1, 3, 15);
        edges[4] = new Edge(2, 3, 4);

        kruskals();
    }
}
