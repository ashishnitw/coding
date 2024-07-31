package graph.educative;

import graph.implementations.DirectedGraphUsingList;
import linkedlist.implementations.DoublyLinkedList;

import java.util.Arrays;

public class FindMotherVertex {
  public static int findMotherVertex(DirectedGraphUsingList g) {
    int n = g.vertices;
    boolean[] visited = new boolean[n];
    // To store last finished vertex (or mother vertex)
    int lastV = 0;
    // Do a DFS traversal and find the last finished vertex
    for (int i = 0; i < n; i++) {
      if (visited[i] == false) {
        visited = DFS(g, i, visited);
        lastV = i;
      }
    }
    // If there exist mother vertex (or vetices) in given
    // graph, then lastV must be one (or one of them)
    Arrays.fill(visited, false);
    boolean[] visitedNew = DFS(g, lastV, visited);
    for (int i = 0; i < visitedNew.length; i++){
      if(visitedNew[i] == false){
        return -1;
      }
    }
    return lastV;
  }
  public static boolean[] DFS(DirectedGraphUsingList g, int node, boolean[] visited) {
    visited[node] = true;
    DoublyLinkedList<Integer>.Node temp = null;
    if (g.adjacencyList[node] !=null)
      temp = g.adjacencyList[node].headNode;
    while(temp != null){
      if(visited[temp.data]){
        temp = temp.nextNode;
      }
      else{
        visited[temp.data] = true;
        visited = DFS(g, temp.data, visited);
        temp = temp.nextNode;
      }
    }
    return visited;
  }
  public static void main(String args[]) {
    DirectedGraphUsingList g = new DirectedGraphUsingList(4);
    g.addEdge(0,1);
    g.addEdge(1,2);
    g.addEdge(3,0);
    g.addEdge(3,1);
    g.printGraph();
    System.out.println("Mother Vertex is: " + findMotherVertex(g));
  }
}
