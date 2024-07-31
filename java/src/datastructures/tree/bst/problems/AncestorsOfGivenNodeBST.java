package datastructures.tree.bst.problems;

import datastructures.tree.binarytree.implementation.BTNode;

public class AncestorsOfGivenNodeBST {

    // Method to print ancestors of a given node in a binary search tree
    // Time complexity: O(h) where h is the height of the tree
    // Space complexity: O(1)
    public static void printAncestors(BTNode root, int key) {
        if (root == null)
            return;
        BTNode curr = root;
        while (curr != null && curr.data != key) {
            System.out.print(curr.data + ", ");
            if (key < curr.data) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }

    public static void printAncestorsRec(BTNode root, int key) {
        if (root == null)
            return;
        if (root.data == key)
            return;
        System.out.print(root.data + ", ");
        if (key < root.data)
            printAncestorsRec(root.left, key);
        else
            printAncestorsRec(root.right, key);
    }

    public static void main(String[] args) {
        /**
            * Binary Search Tree
         *               5
         *              / \
         *             2   8
         *            / \  / \
         *           1  4  6  9
         *             /
         *            3
         * */
        // Create a binary search tree
        BTNode tree = new BTNode(5);
        tree.left = new BTNode(2);
        tree.right = new BTNode(8);
        tree.left.left = new BTNode(1);
        tree.left.right = new BTNode(4);
        tree.left.right.left = new BTNode(3);
        tree.right.left = new BTNode(6);
        tree.right.right = new BTNode(9);

        // Print ancestors of a given node
        System.out.print("Ancestors of 3: ");
        printAncestors(tree, 3);
        System.out.print("\nAncestors of 3: ");
        printAncestorsRec(tree, 3);
        System.out.print("\nAncestors of 6: ");
        printAncestors(tree, 6);
        System.out.print("\nAncestors of 6: ");
        printAncestorsRec(tree, 6);
    }
}
