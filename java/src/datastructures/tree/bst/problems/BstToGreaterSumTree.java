package datastructures.tree.bst.problems;

import datastructures.tree.binarytree.implementation.BTNode;
import datastructures.tree.binarytree.traversal.BinaryTreeTraversal;

/**
 * Given a BST, transform it into a greater sum tree where each node contains the sum of all nodes greater than that node.
 * */
public class BstToGreaterSumTree {

    static int sum = 0;

    // Traverse the tree in reverse inorder and keep updating the sum
    private static void transformTree(BTNode root) {
        if (root == null)
            return;
        transformTree(root.right);
        System.out.println("Updating: " + root.data + " to " + (root.data + sum));
        root.data += sum;
        sum = root.data;
        transformTree(root.left);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(11);
        root.left = new BTNode(2);
        root.right = new BTNode(29);
        root.left.left = new BTNode(1);
        root.left.right = new BTNode(7);
        root.right.left = new BTNode(15);
        root.right.right = new BTNode(40);
        root.right.right.left = new BTNode(35);

        System.out.println("Inorder Traversal of Original Tree:");
        BinaryTreeTraversal.inOrderTraverse(root);
        System.out.println("\nTransforming Tree to Greater Sum Tree:");
        transformTree(root);
        System.out.println("\nInorder Traversal of Transformed Tree:");
        BinaryTreeTraversal.inOrderTraverse(root);
    }
}
