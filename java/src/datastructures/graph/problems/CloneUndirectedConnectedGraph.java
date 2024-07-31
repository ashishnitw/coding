package datastructures.graph.problems;

import java.util.*;

public class CloneUndirectedConnectedGraph {
    static class Node {
        int val;
        List<Node> neighbors;
        Node(int x) {
            val = x;
            neighbors = new ArrayList<>();
        }

        public Node cloneGraphUsingDfs(Node node) {
            Map<Node, Node> map = new HashMap<>();
            return null;
        }

        public Node dfs(Node node, Map<Node, Node> map) {
            if (map.containsKey(node)) {
                return map.get(node);
            }
            Node cloneNode = new Node(node.val);
            map.put(node, cloneNode);
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(dfs(neighbor, map));
            }
            return cloneNode;
        }

        public Node cloneGraphUsingBfs(Node node) {
            return null;
        }
    }

    public static void main(String[] args) {
        // Create a graph
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node3, node1);
    }
}
