package graph.educative;

import graph.implementations.UndirectedGraphUsingList;
import linkedlist.implementations.DoublyLinkedList;

public class CountEdgesUndirectedGraph {
  public static int numEdges(UndirectedGraphUsingList g) {
    int count = 0;
    int n = g.vertices;
    for (int i=0; i<n; i++) {
      DoublyLinkedList<Integer>.Node temp = null;
      if (g.adjacencyList[i] != null)
        temp = g.adjacencyList[i].headNode;
      while (temp != null) {
        count++;
        temp = temp.nextNode;
      }
    }
    return count/2;
  }
  public static void main(String args[]) {
    UndirectedGraphUsingList g = new UndirectedGraphUsingList(9);
    g.addEdge(0,2);
    g.addEdge(0,5);
    g.addEdge(2,3);
    g.addEdge(2,4);
    g.addEdge(5,3);
    g.addEdge(5,6);
    g.addEdge(3,6);
    g.addEdge(6,7);
    g.addEdge(6,8);
    g.addEdge(6,4);
    g.addEdge(7,8);
    g.printGraph();
    System.out.println("Number of edges: " + numEdges(g));
    System.out.println();
    UndirectedGraphUsingList g2 = new UndirectedGraphUsingList(7);
    g2.addEdge(1,2);
    g2.addEdge(1,3);
    g2.addEdge(3,4);
    g2.addEdge(3,5);
    g2.addEdge(2,5);
    g2.addEdge(2,4);
    g2.addEdge(4,6);
    g2.addEdge(4,5);
    g2.addEdge(6,5);
    g2.printGraph();
    System.out.println("Number of edges: " + numEdges(g2));
  }
}
