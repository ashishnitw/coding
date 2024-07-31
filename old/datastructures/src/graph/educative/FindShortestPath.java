package graph.educative;

import graph.implementations.UndirectedGraphUsingList;
import linkedlist.implementations.DoublyLinkedList;

import java.util.LinkedList;
import java.util.Queue;

public class FindShortestPath {
  public static int findMin(UndirectedGraphUsingList g, int source, int destination) {
    if (source == destination)
      return 0;
    int result = 0;
    int n = g.vertices;
    boolean[] visited = new boolean[n];
    int[] distance = new int[n];
    Queue<Integer> queue = new LinkedList<>();
    queue.add(source);
    visited[source] = true;
    while(!queue.isEmpty()) {
      int curr = queue.poll();
      DoublyLinkedList<Integer>.Node temp = null;
      if (g.adjacencyList[curr] != null)
        temp = g.adjacencyList[curr].headNode;
      while(temp != null) {
        if(!visited[temp.data]) {
          queue.add(temp.data);
          visited[temp.data] = true;
          distance[temp.data] = distance[curr] + 1;
        }
        if(temp.data == destination)
          return distance[destination];
        temp = temp.nextNode;
      }
    }
    return -1;
  }
  public static void main(String args[]) {
    UndirectedGraphUsingList g=new UndirectedGraphUsingList(5);
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,3);
    g.addEdge(3,4);
    g.addEdge(1,4);
    System.out.println(findMin(g, 0, 4));
  }
}
