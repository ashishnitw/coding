package datastructures.graph.problems;

import java.util.ArrayList;
import java.util.List;

public class CheckIfGraphIsTree {

    int V;
    List<List<Integer>> adjList;

    public CheckIfGraphIsTree(int V) {
        this.V = V;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public boolean isTree() {
        boolean[] visited = new boolean[V];

        if (isCyclic(0, visited, -1))
            return false;

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }

    public boolean isCyclic(int v, boolean[] visited, int parent) {
        visited[v] = true;

        for (int i : adjList.get(v)) {
            if (!visited[i]) {
                if (isCyclic(i, visited, v))
                    return true;
            } else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        CheckIfGraphIsTree graph = new CheckIfGraphIsTree(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        System.out.println(graph.isTree());
    }
}
