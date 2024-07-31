package algoexpert.easy;

import datastructures.tree.binarytree.implementation.BTNode;
import datastructures.tree.binarytree.traversal.BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class BranchSums {
    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        root.left.left.left = new BTNode(8);
        root.left.left.right = new BTNode(9);
        root.left.right.left = new BTNode(10);

        BinaryTreeTraversal.levelOrderTraverse(root);
        System.out.println("\nBranch sums: ");
        printBranchSums(root);
    }

    private static void printBranchSums(BTNode root) {
        List<Integer> sums = new ArrayList<>();
        printBranchSumsHelper(root, sums, 0);
        for (int sum : sums)
            System.out.print(sum + ", ");
    }

    private static void printBranchSumsHelper(BTNode node, List<Integer> sums, int currentSum) {
        if (node == null)
            return;
        currentSum += node.data;
        if (node.left == null && node.right == null) {
            sums.add(currentSum);
            return;
        }
        printBranchSumsHelper(node.left, sums, currentSum);
        printBranchSumsHelper(node.right, sums, currentSum);
    }
}
