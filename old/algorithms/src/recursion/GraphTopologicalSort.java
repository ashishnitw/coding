package recursion;

import java.util.LinkedList;
import java.util.Stack;

public class GraphTopologicalSort {
  int numVertices;
  LinkedList<Integer>[] list;
  public GraphTopologicalSort(int numVertices) {
    this.numVertices = numVertices;
    list = new LinkedList[numVertices];
    for (int i = 0; i < numVertices; i++)
      list[i] = new LinkedList<>();
  }
  public void addEdge(int fromNode, int toNode) {
    list[fromNode].addFirst(toNode);
  }
  public void topologicalSorting() {
    boolean[] visited = new boolean[numVertices];
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < numVertices; i++) {
      if (!visited[i]) {
        topologicalSortRecursive(i, visited, st);
      }
    }
    System.out.println("Topological Sort: ");
    int size = st.size();
    for (int i = 0; i < size; i++) {
      System.out.print(st.pop() + " ");
    }
  }

  public void topologicalSortRecursive(int start, boolean[] visited, Stack<Integer> ts) {
    visited[start] = true;
    for (int i = 0; i < list[start].size(); i++) {
      int vertex = list[start].get(i);
      if (!visited[vertex])
        topologicalSortRecursive(vertex, visited, ts);
    }
    ts.push(start);
  }

  public static void main( String args[] ) {
    int nVertices = 5;
    GraphTopologicalSort g = new GraphTopologicalSort(nVertices);
    g.addEdge(0, 1);
    g.addEdge(0, 4);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 3);
    g.addEdge(2, 4);
    // Root node given as argument to the function
    g.topologicalSorting();
  }
}
