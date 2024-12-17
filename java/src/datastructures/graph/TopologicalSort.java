package datastructures.graph;

import java.util.*;

public class TopologicalSort {

    /** Kahn's Algorithm (BFS approach)
     * Time:
     * Space:
     * */
    public static void topologicalSortBFS(int V, List<List<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        int[] inDegree = new int[V];

        // Calculate in-degrees of all vertices
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        // Queue to store vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            for (int neighbor : adj.get(curr)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.add(neighbor);
            }
        }
        System.out.print("Topological sorting: ");
        for (int a : result)
            System.out.print(a + " ");
        System.out.println();
    }

    // (DFS approach)
    public static void topologicalSortDFS(int V, List<List<Integer>> adj) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for (int i=0; i<V; i++) {
            if (!visited[i])
                dfs(i, visited, stack, adj);
        }
        System.out.print("Topological sorting: ");
        while (!stack.empty())
            System.out.print(stack.pop() + " ");
        System.out.println();
    }

    public static void dfs(int curr, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adj) {
        visited[curr] = true;
        for (int i : adj.get(curr)) {
            if (!visited[i])
                dfs(i, visited, stack, adj);
        }
        stack.push(curr);
    }

    public static void main(String[] args) {

        // Number of vertices
        int vertices = 6;

        // Adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Define edges of the graph
        adjList.get(5).add(2);
        adjList.get(5).add(0);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        topologicalSortBFS(vertices, adjList);
        topologicalSortDFS(vertices, adjList);
    }
}
