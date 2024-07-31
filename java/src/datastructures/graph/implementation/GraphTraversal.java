package datastructures.graph.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphTraversal {

    private int V;
    private List<Integer>[] adj;

    public GraphTraversal(int V) {
        this.V = V;
        adj = new List[V];
        for(int i=0; i<V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void dfsConnectedGraph(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("DFS traversal --> ");
        dfsUtil(start, visited);
        System.out.println();
    }

    public void dfsDisconnectedGraph() {
        boolean[] visited = new boolean[V];
        System.out.print("DFS traversal --> ");
        for(int i=0; i<V; i++) {
            if(!visited[i]) {
                dfsUtil(i, visited);
            }
        }
        System.out.println();
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for(int i : adj[v]) {
            if(!visited[i]) {
                dfsUtil(i, visited);
            }
        }
    }

    public void bfsConnectedGraph(int start) {
        boolean[] visited = new boolean[V];
        System.out.print("BFS traversal --> ");
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for(int i : adj[curr]) {
                if(!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.dfsConnectedGraph(2);
        graph.dfsDisconnectedGraph();
        graph.bfsConnectedGraph(2);
    }
}
