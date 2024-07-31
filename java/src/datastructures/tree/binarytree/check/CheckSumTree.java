package datastructures.tree.binarytree.check;

import datastructures.tree.binarytree.implementation.BTNode;

/**
 *  A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree.
 * */
public class CheckSumTree {

    public static void main(String[] args) {
        /**
         *          26
         *         /  \
         *        10   3
         *        / \   \
         *       4   6   3
         * */
        BTNode root = new BTNode(26);
        root.left = new BTNode(10);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(6);

        System.out.println("Is the tree a sum tree: " + isSumTree(root)); // false

        root.right.right = new BTNode(3);
        System.out.println("Is the tree a sum tree: " + isSumTree(root)); // true
    }

    private static boolean isSumTree(BTNode root) {
        return checkAndSum(root) != Integer.MIN_VALUE;
    }

    private static int checkAndSum(BTNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)    // Leaf node
            return root.data;

        // Recursively check for left and right subtree
        int leftSum = checkAndSum(root.left);
        int rightSum = checkAndSum(root.right);

        // If any of the subtree is not a sum tree, return Integer.MIN_VALUE
        if (leftSum == Integer.MIN_VALUE || rightSum == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        // If the current node is not a sum of left and right subtree, return Integer.MIN_VALUE
        if (root.data == leftSum + rightSum) {
            return root.data + leftSum + rightSum;
        }
        return Integer.MIN_VALUE;
    }



}
