package datastructures.tree.binarytree.problems;

import datastructures.tree.binarytree.implementation.BTNode;

public class AncestorsOfGivenNode {

    public static boolean printAncestors(BTNode root, int key) {
        if (root == null)    // If the root is null, return false
            return false;
        if (root.data == key)   // If the key is found, return true
            return true;
        if (printAncestors(root.left, key) || printAncestors(root.right, key)) {    // If the key is found in the left or right subtree
            System.out.print(root.data + ", ");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /**
            * Binary Tree
         *               3
         *              / \
         *             5   1
         *            / \  / \
         *           6  2  0  8
         *             / \
         *            7  4

         * */
        // Create a binary tree
        BTNode tree = new BTNode(3);
        tree.left = new BTNode(5);
        tree.right = new BTNode(1);
        tree.left.left = new BTNode(6);
        tree.left.right = new BTNode(2);
        tree.left.right.left = new BTNode(7);
        tree.left.right.right = new BTNode(4);
        tree.right.left = new BTNode(0);
        tree.right.right = new BTNode(8);

        // Print ancestors of a given node
        System.out.println("Ancestors of 7: ");
        printAncestors(tree, 7);
        System.out.println("\nAncestors of 4: ");
        printAncestors(tree, 0);
    }
}
