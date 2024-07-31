package algoexpert.easy;

import datastructures.tree.binarytree.implementation.BTNode;
import datastructures.tree.binarytree.traversal.BinaryTreeTraversal;

public class FindClosestValueBST {

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(15);
        root.left.left = new BTNode(2);
        root.left.right = new BTNode(5);
        root.left.left.left = new BTNode(1);
        root.right.left = new BTNode(13);
        root.right.right = new BTNode(22);
        root.right.left.right = new BTNode(14);

        BinaryTreeTraversal.inOrderTraverse(root);

        System.out.println("\nClosest value: " + findClosestValueInBST(root, 12, Integer.MIN_VALUE));
        System.out.println("Closest value: " + findClosestValueInBSTIter(root, 12));
    }

    // Average: O(log(n)) time, O(log(n)) space
    // Worst: O(n) time, O(n) space
    public static int findClosestValueInBST(BTNode node, int target, int closest) {
        if (node == null)
            return closest;
        if (Math.abs(target - closest) > Math.abs(target - node.data))
            closest = node.data;
        if (node.data < target)
            return findClosestValueInBST(node.right, target, closest);
        else if (node.data > target)
            return findClosestValueInBST(node.left, target, closest);
        else
            return closest;
    }

    // Average: O(log(n)) time, O(1) space
    // Worst: O(n) time, O(1) space
    public static int findClosestValueInBSTIter(BTNode node, int target) {
        BTNode curr = node;
        int closest = Integer.MAX_VALUE;
        while (curr != null) {
            if (Math.abs(target - closest) > Math.abs(target - curr.data))
                closest = curr.data;
            if (curr.data < target)
                curr = curr.right;
            else if (curr.data > target)
                curr = curr.left;
            else
                break;
        }
        return closest;
    }
}
