package tree.btchecking;

import tree.implementations.NodeBasic;

public class CheckChildrenSumProperty {
  NodeBasic root;
  public CheckChildrenSumProperty() { root = null; }

  public static boolean isChildrenSumProperty(NodeBasic node) {
    int leftData = 0, rightData = 0;
    if(node == null || (node.left == null && node.right == null))
      return true;
    else {
      if(node.left != null)
        leftData = node.left.data;
      if(node.right != null)
        rightData = node.right.data;
      if(node.data == leftData + rightData && isChildrenSumProperty(node.left) && isChildrenSumProperty(node.right))
        return true;
      else
        return false;
    }
  }

  public static void main(String[] args) {
    CheckChildrenSumProperty tree = new CheckChildrenSumProperty();
    tree.root = new NodeBasic(10);
    tree.root.left = new NodeBasic(8);
    tree.root.right = new NodeBasic(2);
    tree.root.left.left = new NodeBasic(3);
    tree.root.left.right = new NodeBasic(5);
    tree.root.right.right = new NodeBasic(2);
    System.out.print("\nSum Property:");
    System.out.print(isChildrenSumProperty(tree.root));

  }
}
