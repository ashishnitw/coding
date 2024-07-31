package graph.educative;

import graph.implementations.DirectedGraphUsingList;
import linkedlist.implementations.DoublyLinkedList;

public class DetectCycleGraph {
  public static boolean detectCycle(DirectedGraphUsingList g) {
    int n = g.vertices;
    boolean[] visited = new boolean[n];
    boolean[] stackFlag = new boolean[n];
    for (int i = 0; i < n; i++) {
      //Check cyclic on each node
      if (isCyclic(g, i, visited, stackFlag))
        return true;
    }
    return false;
  }
  public static boolean isCyclic(DirectedGraphUsingList g, int v, boolean[] visited, boolean[] stackFlag) {
    if (stackFlag[v])
      return true;  // if node is currently in stack that means we have found a cycle
    if (visited[v])
      return false; // if it is already visited (and not in Stack) then there is no cycle
    visited[v] = true; stackFlag[v] = true;
    // check adjacency list of the node
    DoublyLinkedList<Integer>.Node temp = null;
    if(g.adjacencyList[v] != null)
      temp = g.adjacencyList[v].headNode;
    while(temp != null) {
      if(isCyclic(g, temp.data, visited, stackFlag))
        return true;
      temp = temp.nextNode;
    }
    stackFlag[v] = false;
    return false;
  }
  public static void main(String args[]) {
    DirectedGraphUsingList g1 = new DirectedGraphUsingList(4);
    g1.addEdge(0,1);
    g1.addEdge(1,2);
    g1.addEdge(1,3);
    g1.addEdge(3,0);
    g1.printGraph();
    System.out.println(detectCycle(g1));

    System.out.println();
    DirectedGraphUsingList g2 = new DirectedGraphUsingList(3);
    g2.addEdge(0,1);
    g2.addEdge(1,2);
    g2.printGraph();
    System.out.println(detectCycle(g2));
  }
}
