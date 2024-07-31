package datastructures.tree.binarytree.problems;

import datastructures.tree.binarytree.implementation.BTNode;

public class PrintNodesDistanceKFromRoot {

    private static void printNodesAtDistanceK(BTNode node, int k) {
        if (node == null || k < 0)
            return;
        if (k == 0) {
            System.out.print(node.data + ", ");
            return;
        }
        printNodesAtDistanceK(node.left, k - 1);
        printNodesAtDistanceK(node.right, k - 1);
    }

    public static void main(String[] args) {
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

        // Print nodes at distance k from root
        printNodesAtDistanceK(tree, 2);
    }
}
