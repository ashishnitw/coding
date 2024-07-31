package tree.btchecking;

import tree.implementations.BinaryTreeBasic;
import tree.implementations.NodeBasic;

public class CheckSumCoveredUncoveredNodes {

  public static int level(NodeBasic node, NodeBasic a, int level) {
    if (node == null) return 0;
    if (node == a) return level;
    int l = level(node.left, a, level + 1);
    if(l != 0)
      return l;
    return level(node.right, a, level + 1);
  }

  public static boolean isSibling(NodeBasic node, NodeBasic a, NodeBasic b) {
    if(node == null) return false;
    return ((node.left == a && node.right == b)
            || (node.left == b && node.left == a)
            || (isSibling(node.left, a, b))
            || (isSibling(node.right, a, b)));
  }

  public static boolean isCousins(NodeBasic root, NodeBasic a, NodeBasic b) {
    if (level(root, a, 0) == level(root, b, 0)) {
      if(!isSibling(root, a, b)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    BinaryTreeBasic tree = new BinaryTreeBasic();
    tree.root = new NodeBasic(8);
    tree.root.left = new NodeBasic(3);
    tree.root.left.left = new NodeBasic(1);
    tree.root.left.right = new NodeBasic(6);
    tree.root.left.right.left = new NodeBasic(4);
    tree.root.left.right.right = new NodeBasic(8);

    tree.root.right = new NodeBasic(3);
    tree.root.right.right = new NodeBasic(2);
    tree.root.right.right.left = new NodeBasic(1);
    System.out.print("\nisCousin: " + isCousins(tree.root, tree.root.left.left, tree.root.right.right));

  }
}
