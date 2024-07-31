package datastructures.tree.binarytree.check;

import datastructures.tree.binarytree.implementation.BTNode;

public class CheckPerfectBinaryTree {

    public static boolean isPerfect(BTNode root) {
        int depth = getDepth(root);
        return isPerfectRec(root, depth, 0);
    }
    public static boolean isPerfectRec(BTNode root, int depth, int level) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null)    // lead node
            return depth == level + 1;
        if (root.left == null || root.right == null)
            return false;
        return isPerfectRec(root.left, depth, level + 1) && isPerfectRec(root.right, depth, level + 1);
    }

    // Depth of left most leaf
    public static int getDepth(BTNode root) {
        if (root == null)
            return 0;
        return 1 + getDepth(root.left);
    }

    public static void main(String[] args) {
        //
        BTNode root = new BTNode(10);
        root.left = new BTNode(20);
        root.right = new BTNode(30);
        root.left.left = new BTNode(40);
        root.left.right = new BTNode(50);
        root.right.left = new BTNode(60);

        System.out.println(isPerfect(root));

        root.right.right = new BTNode(70);
        System.out.println(isPerfect(root));
    }
}
