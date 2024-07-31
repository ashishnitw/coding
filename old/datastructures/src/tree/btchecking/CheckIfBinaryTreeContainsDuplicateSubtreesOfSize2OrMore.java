package tree.btchecking;

import tree.implementations.NodeBasic;

import java.util.HashSet;

public class CheckIfBinaryTreeContainsDuplicateSubtreesOfSize2OrMore {
  static char MARKER = '$';

  private static String dupSub(NodeBasic root) {
    HashSet<String> subtrees = new HashSet<>();
    return dupSubUtil(root, subtrees);
  }

  private static String dupSubUtil(NodeBasic root, HashSet<String> subtrees) {
    String s = "";
    if (root == null)
      return s + MARKER;
    String lStr = dupSubUtil(root.left,subtrees);
    if (lStr.equals(s))
      return s;
    String rStr = dupSubUtil(root.right,subtrees);
    if (rStr.equals(s))
      return s;
    // Serialize current subtree
    s = s + root.data + lStr + rStr;
    if (s.length() > 3 && subtrees.contains(s))
      return "";
    subtrees.add(s);
    return s;
  }

  public static void main(String[] args) {
    NodeBasic root = new NodeBasic('A');
    root.left = new NodeBasic('B');
    root.right = new NodeBasic('C');
    root.left.left = new NodeBasic('D');
    root.left.right = new NodeBasic('E');
    root.right.right = new NodeBasic('B');
    root.right.right.right = new NodeBasic('E');
    root.right.right.left= new NodeBasic('D');
    String str = dupSub(root);
    if(str.equals(""))
      System.out.print(" Yes ");
    else
      System.out.print(" No ");
  }

}
