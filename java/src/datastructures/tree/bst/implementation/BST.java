package datastructures.tree.bst.implementation;

import datastructures.tree.binarytree.implementation.BTNode;
import datastructures.tree.binarytree.implementation.BinaryTree;
import datastructures.tree.binarytree.traversal.BinaryTreeTraversal;

public class BST {

    private BTNode root;

    public static BTNode insert(BTNode root, int value) {
        if (root == null) {
            System.out.println();
            return new BTNode(value);
        } else if (value > root.data) {
            root.left = insert(root.right, value);
        } else if(value < root.data) {
            root.right = insert(root.left, value);
        }
        return root;
    }

    public void delete(int value) {
    }

    public boolean search(int value) {
        return false;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.root = insert(tree.root, 10);
        tree.root = insert(tree.root, 5);
        tree.root = insert(tree.root, 15);
        tree.root = insert(tree.root, 2);
        tree.root = insert(tree.root, 5);
        tree.root = insert(tree.root, 20);

        BinaryTreeTraversal.levelOrderTraverse(tree.root);

    }
}
