package datastructures.tree.binarytree.problems;

import datastructures.tree.binarytree.implementation.BTNode;

public class PrintNodesDistanceKFromTarget {

    private static int printNodesAtDistanceK(BTNode node, BTNode target, int k) {
        if (node == null)
            return -1;
        if (node == target) {
            printNodesAtDistanceKDown(node, k);
            return 0;
        }
        int dl = printNodesAtDistanceK(node.left, target, k);
        if (dl != -1) {
            if (dl + 1 == k)
                System.out.print(node.data + ", ");
            else
                printNodesAtDistanceKDown(node.right, k - dl - 2);
            return 1 + dl;
        }
        int dr = printNodesAtDistanceK(node.right, target, k);
        if (dr != -1) {
            if (dr + 1 == k)
                System.out.print(node.data + ", ");
            else
                printNodesAtDistanceKDown(node.left, k - dr - 2);
            return 1 + dr;
        }
        return -1;
    }

    private static void printNodesAtDistanceKDown(BTNode node, int k) {
        if (node == null || k < 0)
            return;
        if (k == 0) {
            System.out.print(node.data + ", ");
            return;
        }
        printNodesAtDistanceKDown(node.left, k - 1);
        printNodesAtDistanceKDown(node.right, k - 1);
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

        BTNode target = tree.left;

        // Print nodes at distance k from root
        printNodesAtDistanceK(tree, target, 2);
    }
}
