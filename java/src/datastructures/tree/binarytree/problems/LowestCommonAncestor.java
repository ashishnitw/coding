package datastructures.tree.binarytree.problems;

import datastructures.tree.binarytree.implementation.BTNode;

public class LowestCommonAncestor {

    public static void main(String[] args) {

        // Construct the binary tree
        //         3
        //        / \
        //       5   1
        //      / \ / \
        //     6  2 0  8
        //       / \
        //      7   4

        BTNode root = new BTNode(3);
        root.left = new BTNode(5);
        root.right = new BTNode(1);
        root.left.left = new BTNode(6);
        root.left.right = new BTNode(2);
        root.left.right.left = new BTNode(7);
        root.left.right.right = new BTNode(4);
        root.right.left = new BTNode(0);
        root.right.right = new BTNode(8);

        System.out.println(lowestCommonAncestor(root, root.left, root.right).data); // 3
        System.out.println(lowestCommonAncestor(root, root.left, root.left.right.right).data); // 5
    }

    private static BTNode lowestCommonAncestor(BTNode root, BTNode a, BTNode b) {
        if (root == null)
            return null;
        if (root == a || root == b)
            return root;

        BTNode left = lowestCommonAncestor(root.left, a, b);
        BTNode right = lowestCommonAncestor(root.right, a, b);

        if (left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
