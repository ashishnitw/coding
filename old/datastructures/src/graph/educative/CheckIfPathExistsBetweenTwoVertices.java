package graph.educative;

import graph.implementations.DirectedGraphUsingList;
import linkedlist.implementations.DoublyLinkedList;

import java.util.Stack;

public class CheckIfPathExistsBetweenTwoVertices {
  public static boolean checkPath(DirectedGraphUsingList g, int source, int destination) {
    int n = g.vertices;
    if (source == destination)
      return true;
    boolean[] visited = new boolean[n];
    Stack<Integer> stack = new Stack<>();
    stack.push(source);
    visited[source] = true;
    //Traverse while stack is not empty
    while (!stack.isEmpty()) {
      int curr = stack.pop();
      DoublyLinkedList<Integer>.Node temp = null;
      if (g.adjacencyList[curr] != null)
        temp = g.adjacencyList[curr].headNode;
      while (temp != null) {
        if (!visited[temp.data]) {
          if (temp.data == destination)
            return true;
          stack.push(temp.data);
          visited[temp.data] = true;
        }
        temp = temp.nextNode;
      }
    }
    return false;
  }
  public static void main(String args[]) {
    DirectedGraphUsingList g1 = new DirectedGraphUsingList(9);
    g1.addEdge(0,2);
    g1.addEdge(0,5);
    g1.addEdge(2,3);
    g1.addEdge(2,4);
    g1.addEdge(5,3);
    g1.addEdge(5,6);
    g1.addEdge(3,6);
    g1.addEdge(6,7);
    g1.addEdge(6,8);
    g1.addEdge(6,4);
    g1.addEdge(7,8);
    g1.printGraph();
    System.out.println("Path exists: " + checkPath(g1, 0, 7));
    System.out.println();
    DirectedGraphUsingList g2 = new DirectedGraphUsingList(4);
    g2.addEdge(0,1);
    g2.addEdge(1,2);
    g2.addEdge(1,3);
    g2.addEdge(2,3);

    g2.printGraph();
    System.out.println("Path exists: " + checkPath(g2, 3, 0));
  }
}
