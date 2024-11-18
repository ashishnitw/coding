package algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    int vertices;
    List<List<Node>> adj;

    public Dijkstra(int vertices) {
        this.vertices = vertices;
        adj = new ArrayList<>();
        for(int i=0; i<vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addNode(int u, int v, int weight) {
        adj.get(u).add(new Node(v, weight));
        adj.get(v).add(new Node(u, weight));
    }

    // Node class to store vertex and its weight
    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra(9);


    }
}
