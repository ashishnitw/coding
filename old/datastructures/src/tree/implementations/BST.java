package tree.implementations;

public class BST {
  private Node root;
  public Node getRoot() { return root; }
  public void setRoot(Node root) { this.root = root; }
  public boolean inEmpty() { return root == null; }
  public boolean add(int value) {
    if(root == null) {
      root = new Node(value);
      return true;
    }
    Node curr = root;
    while(curr != null) {
      Node left = curr.getLeft();
      Node right = curr.getRight();
      if(curr.getData() > value) {
        if(left == null) {
          left = new Node(value);
          curr.setLeft(left);
          return true;
        }
        curr = left;
      } else {
        if(right == null) {
          right = new Node(value);
          curr.setRight(right);
          return true;
        }
        curr = right;
      }
    }
    return false;
  }
  public boolean addRec(int value) {
    root = insertRec(root, value);
    return true;
  }
  public Node insertRec(Node node, int value) {
    if(node == null)
      return new Node(value);
    else if(value < node.getData()) {
      node.setLeft(insertRec(node.getLeft(), value));
    } else if(value > node.getData()){
      node.setRight(insertRec(node.getRight(), value));
    } else {
      return node;
    }
    return node;
  }
  public Node search(int value) {
    if(root == null || root.getData() == value) return root;
    Node curr = root;
    while(curr != null) {
      if(curr.getData() == value)
        return curr;
      else if (curr.getData() > value)
        curr = curr.getLeft();
      else
        curr = curr.getRight();
    }
    System.out.println(value + " not found in tree");
    return null;
  }
  public Node searchRec(Node node, int value) {
    if(node == null || node.getData() == value) return node;
    if(value < node.getData())
      return searchRec(node.getLeft(), value);
    else
      return searchRec(node.getRight(), value);
  }
  public boolean delete(int value, Node curr) {
    if (root == null) return false;
    Node parent = null; //To Store parent of current Node
    // find node to be deleted
    while(curr != null && curr.getData() != value) {
      parent = curr;
      if(curr.getData() > value)
        curr = curr.getLeft();
      else
        curr = curr.getRight();
    }
    if(curr == null) // node not found
      return false;
    else if(curr.getLeft() == null && curr.getRight() == null) {  //1. Node is Leaf Node
      if(root.getData() == curr.getData()) {
        setRoot(null);
        return true;
      } else if(curr.getData() < parent.getData()) {  // if it is left child
        parent.setLeft(null);
        return true;
      } else {   // if it is right child
        parent.setRight(null);
        return true;
      }
    } else if(curr.getLeft() == null) { // if it has only right child
      if(root.getData() == curr.getData()) {
        setRoot(curr.getRight());
        return true;
      } else if(curr.getData() < parent.getData()) {
        parent.setLeft(curr.getRight());
        return true;
      } else {
        parent.setRight(curr.getRight());
        return true;
      }
    } else if(curr.getRight() == null) {  // if it has only left child
      if(root.getData() == curr.getData()) {
        setRoot(curr.getLeft());
        return true;
      } else if(curr.getData() < parent.getData()) {
        parent.setLeft(curr.getLeft());
        return true;
      } else {
        parent.setRight(curr.getLeft());
        return true;
      }
    } else {  // it has 2 childs
      //Find Least Value Node in right-subtree of current Node
      Node leastNode = getLeastNode(curr.getRight());
      int temp = leastNode.getData();
      delete(temp, root);
      curr.setData(temp);
      return true;
    }
  }
  public Node getLeastNode(Node root) {
    Node curr = root;
    while(curr.getLeft() != null) {
      curr = curr.getLeft();
    }
    return curr;
  }
  public Node deleteRec(int value, Node node) {
    if(root == null) return node;
    if(value < node.getData())
      root.setLeft(deleteRec(value, node.getLeft()));
    else if(value > node.getData())
      root.setRight(deleteRec(value, node.getRight()));
    else {
      if (node.getLeft() == null) return node.getRight(); // 1 child
      if (node.getRight() == null) return node.getLeft(); // 1 child
      Node leastNode = getLeastNode(node.getRight());
      node.setData(leastNode.getData());
      node.setRight(deleteRec(value, node.getRight()));
    }
    return node;
  }

  public void printTree(Node current) {
    if (current == null) return;
    System.out.print(current.getData() + ",");
    printTree(current.getLeft());
    printTree(current.getRight());
  }

  public static void main(String args[]) {
    BST bsT = new BST();
    bsT.add(6);
    bsT.add(4);
    bsT.add(9);
    bsT.add(5);
    bsT.add(2);
    bsT.add(8);
    bsT.add(12);
    bsT.add(10);
    bsT.add(14);
    bsT.printTree(bsT.getRoot());
    BST bsT2 = new BST();
    bsT2.addRec(6);
    bsT2.addRec(4);
    bsT2.addRec(9);
    bsT2.addRec(5);
    bsT2.addRec(2);
    bsT2.addRec(8);
    bsT2.addRec(12);
    bsT2.addRec(10);
    bsT2.addRec(14);
    bsT2.printTree(bsT2.getRoot());
    Node temp = bsT.search(5);
    if (temp != null) {
      System.out.println("\n" + temp.getData() + " found in Tree !");
    }
    temp = bsT.search(51);
    if (temp != null) {
      System.out.println("\n" + temp.getData() + " found in Tree !");
    }

    BST bsT3 = new BST();
    bsT3.add(6);
    bsT3.add(7);
    bsT3.add(8);
    bsT3.add(12);
    bsT3.add(1);
    bsT3.add(15);
    System.out.print("Tree : ");
    bsT3.printTree(bsT3.getRoot());
    System.out.print("\nDeleting Node 6: ");
    bsT3.delete(6, bsT3.getRoot());
    bsT3.printTree(bsT3.getRoot());
    System.out.print("\nDeleting Node 15: ");
    bsT3.delete(15, bsT3.getRoot());
    bsT3.printTree(bsT3.getRoot());
    System.out.print("\nDeleting Node 1: ");
    bsT3.delete(1, bsT3.getRoot());
    bsT3.printTree(bsT3.getRoot());
  }

}
