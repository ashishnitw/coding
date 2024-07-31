public class KruskalsMinimumSpanningTree {
  class Edge implements Comparable<Edge> {
    int src, dest, weight;
    @Override
    public int compareTo(Edge o) {
      return this.weight - o.weight;
    }
  }
  // A class to represent a subset for union-find
  class subset {
    int parent, rank;
  }
  int V, E;    // V-> no. of vertices & E->no.of edges
  Edge edge[]; // collection of all edges
  KruskalsMinimumSpanningTree(int v, int e) {
    V = v;
    E = e;
    edge = new Edge[E];
    for (int i=0; i<e; ++i)
      edge[i] = new Edge();
  }
  // A utility function to find set of an element i (uses path compression technique)


  public static void main(String[] args) {

  }
}
