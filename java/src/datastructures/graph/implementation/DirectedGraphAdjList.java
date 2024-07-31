package datastructures.graph.implementation;

import java.util.LinkedList;
import java.util.Queue;

public class DirectedGraphAdjList {
    int V;  // No. of vertices
    LinkedList<Integer> adj[]; // Adjacency List

    public DirectedGraphAdjList(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) { // v = source, w = destination
        adj[v].add(w);
    }

    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Integer node : adj[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public void dfsRec() {
        boolean[] visited = new boolean[V];
        dfsUtil(0, visited);
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer node : adj[v]) {
            if (!visited[node]) {
                dfsUtil(node, visited);
            }
        }
    }

    public void bfs() {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (Integer neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    q.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DirectedGraphAdjList g = new DirectedGraphAdjList(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);


        System.out.println("Graph created");
        g.printGraph();

        System.out.println("DFS traversal");
        g.dfsRec();

        System.out.println("BFS traversal");
        g.bfs();
    }
}
