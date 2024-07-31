package graph.implementations;

import linkedlist.implementations.DoublyLinkedList;

public class UndirectedGraphUsingList {
  public int vertices;
  public DoublyLinkedList<Integer> adjacencyList[];
  @SuppressWarnings("unchecked")
  public UndirectedGraphUsingList(int vertices) {
    this.vertices = vertices;
    adjacencyList = new DoublyLinkedList[vertices];
    for (int i = 0; i < vertices; i++) {
      adjacencyList[i] = new DoublyLinkedList<>();
    }
  }
  public void addEdge(int source, int destination){
    if (source < vertices && destination < vertices){
      this.adjacencyList[source].insertAtEnd(destination);
      //for undirected graph uncomment the line below
      this.adjacencyList[destination].insertAtEnd(source);
    }
  }
  public void printGraph() {
    System.out.println(">>Adjacency List of Directed Graph<<");
    for (int i = 0; i < vertices; i++)
    {
      if(adjacencyList[i]!=null){
        System.out.print("|" + i + "| => ");
        DoublyLinkedList<Integer>.Node temp = adjacencyList[i].getHeadNode();
        while (temp != null)
        {
          System.out.print("[" + temp.data + "] -> ");
          temp = temp.nextNode;
        }
        System.out.println("null");
      }
      else{
        System.out.println("|" + i + "| => "+ "null");
      }
    }
  }
  public static void main( String args[] ) {
    UndirectedGraphUsingList g= new UndirectedGraphUsingList(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 3);
    g.addEdge(3, 0);

    g.printGraph();
  }
}
