package datastructures.tree.binarytree.implementation;

import datastructures.tree.binarytree.traversal.BinaryTreeTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private BTNode root;

    public void insert(int value) {
        BTNode node = new BTNode(value);
        if (root == null) {
            root = node;
            return;
        }
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BTNode temp = queue.poll();
            if(temp.left == null) {
                temp.left = node;
                break;
            } else if(temp.right == null) {
                temp.right = node;
                break;
            } else {
                queue.add(temp.left);
                queue.add(temp.right);
            }
        }
    }

    public void delete(int value) {

    }

    public static int height(BTNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean search(int value) {
        return false;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);
        tree.insert(20);

        BinaryTreeTraversal.levelOrderTraverse(tree.root);
        System.out.println("Height of the tree: " + height(tree.root));
    }
}
