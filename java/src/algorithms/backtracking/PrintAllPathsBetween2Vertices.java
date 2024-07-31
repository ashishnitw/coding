package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPathsBetween2Vertices {

    private int V;
    private List<Integer>[] adj;

    public PrintAllPathsBetween2Vertices(int v) {
        this.V = v;
        adj = new List[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    private void printPaths(int u, int v) {
        boolean[] visited = new boolean[V];
        List<Integer> pathList = new ArrayList<>();
        pathList.add(u);
        printPathsUtil(u, v, visited, pathList);
    }

    private void printPathsUtil(int u, int v, boolean[] visited, List<Integer> pathList) {
        if (u == v) {
            System.out.println(pathList);
            return;
        }
        visited[u] = true;
        for (int i : adj[u]) {
            if (!visited[i]) {
                pathList.add(i);
                printPathsUtil(i, v, visited, pathList);
                pathList.remove(pathList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PrintAllPathsBetween2Vertices graph = new PrintAllPathsBetween2Vertices(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(1, 3);

        graph.printPaths(2, 3); // TODO: Incorrect output
    }
}
