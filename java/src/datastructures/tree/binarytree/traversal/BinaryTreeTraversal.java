package datastructures.tree.binarytree.traversal;

import datastructures.tree.binarytree.implementation.BTNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    public static void main(String[] args) {
        BTNode tree = new BTNode(10);
        tree.left = new BTNode(5);
        tree.right = new BTNode(15);
        tree.left.left = new BTNode(2);
        tree.left.right = new BTNode(5);
        tree.left.left.left = new BTNode(1);
        tree.right.left = new BTNode(13);
        tree.right.right = new BTNode(22);
        tree.right.left.right = new BTNode(14);

        System.out.println("\nIn Order Traversal: ");
        inOrderTraverse(tree);
        System.out.println("\nIn Order Iterative Traversal: ");
        inOrderIterative(tree);
        System.out.println("\nIn Order Morris Traversal: ");
        inOrderMorrisTraversal(tree);

        System.out.println("\nPre Order Traversal: ");
        preOrderTraverse(tree);
        System.out.println("\nPre Order Iterative Traversal: ");
        preOrderIterative(tree);

        System.out.println("\nPost Order Traversal: ");
        postOrderTraverse(tree);
        System.out.println("\nPost Order Iterative Traversal: ");
        postOrderIterative(tree);

        System.out.println("\nLevel Order Traversal: ");
        levelOrderTraverse(tree);
    }

    public static void inOrderTraverse(BTNode tree) {
        if (tree != null) {
            inOrderTraverse(tree.left);
            System.out.print(tree.data + ", ");
            inOrderTraverse(tree.right);
        }
    }

    public static void inOrderIterative(BTNode root) {
        if(root == null)
            return;
        Stack<BTNode> stack = new Stack<>();
        BTNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + ", ");
            curr = curr.right;
        }
    }

    public static void inOrderMorrisTraversal(BTNode root) {
        if(root == null)
            return;
        BTNode curr = root;
        BTNode prev;
        while(curr != null) {
            if(curr.left == null) {
                System.out.print(curr.data + ", ");
                curr = curr.right;
            } else {
                prev = curr.left;
                while (prev.right != null && prev.right != curr)
                    prev = prev.right;
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                }
                else {
                    prev.right = null;
                    System.out.print(curr.data + ", ");
                    curr = curr.right;
                }
            }
        }
    }

    public static void preOrderTraverse(BTNode tree) {
        if (tree != null) {
            System.out.print(tree.data + ", ");
            preOrderTraverse(tree.left);
            preOrderTraverse(tree.right);
        }
    }

    public static void preOrderIterative(BTNode tree) {
        if (tree == null)
            return;
        Stack<BTNode> stack = new Stack<>();
        BTNode curr = tree;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                System.out.print(curr.data + ", ");
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }
    }

    public static void postOrderTraverse(BTNode tree) {
        if (tree != null) {
            postOrderTraverse(tree.left);
            postOrderTraverse(tree.right);
            System.out.print(tree.data + ", ");
        }
    }

    // TODO: Need to verify this
    public static void postOrderIterative(BTNode tree) {
        if (tree == null)
            return;
        Stack<BTNode> stack = new Stack<>();
        BTNode curr = tree;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + ", ");
            curr = curr.right;
        }
    }

    public static void levelOrderTraverse(BTNode root) {
        if (root == null)
            return;
        List<BTNode> list = List.of(root);
        while (!list.isEmpty()) {
            List<BTNode> children = new ArrayList<>();
            for (BTNode node : list) {
                System.out.print(node.data + ", ");
                if (node.left != null)
                    children.add(node.left);
                if (node.right != null)
                    children.add(node.right);
            }
            System.out.println();
            list = children;
        }
    }
}
