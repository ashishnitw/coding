package algoexpert.medium;

import datastructures.tree.binarytree.implementation.BTNode;

public class ValidateBST {
    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(15);
        root.left.left = new BTNode(2);

        System.out.println(validateBST(root));
    }

    private static boolean validateBST(BTNode root) {
        return validateBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean validateBSTHelper(BTNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.data < min || node.data >= max)
            return false;
        return validateBSTHelper(node.left, min, node.data) && validateBSTHelper(node.right, node.data, max);
    }
}
