package datastructures.tree.bst.implementation;

import datastructures.tree.binarytree.implementation.BTNode;

public class BST {

    private BTNode root;

    public void insert(int value) {

    }

    public void delete(int value) {
    }

    public boolean search(int value) {
        return false;
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        tree.insert(20);

        // BinaryTreeTraversal.levelOrderTraverse(tree.root);
    }
}
