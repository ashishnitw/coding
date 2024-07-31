package datastructures.tree.bst.search;

import datastructures.tree.binarytree.implementation.BTNode;

import java.util.Stack;

public class FindKthLargestElementBST {

    static class Count {
        int count = 0;
    }

    // Time Complexity: O(h + k) where h is height of BST
    // Space Complexity: O(h)
    private static void findKthLargestElement(BTNode root, int k) {
        Count count = new Count();
        findKthLargestElementUtil(root, k, count);
    }

    private static void findKthLargestElementUtil(BTNode node, int k, Count count) {
        if (node == null || count.count >= k)
            return;
        // Reverse Inorder Traversal
        findKthLargestElementUtil(node.right, k, count);
        count.count++;
        if (count.count == k) {
            System.out.println(k + "th Largest Element: " + node.data);
            return;
        }
        findKthLargestElementUtil(node.left, k, count);
    }

    private static int findKthLargestElementIterative(BTNode root, int k) {
        Stack<BTNode> stack = new Stack<>();
        BTNode curr = root;
        int count = 0;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop(); // Process the right node
            count++;    // Increment count
            if (count == k) {
                return curr.data;   // kth largest element
            }
            curr = curr.left;
        }
        return -1;
    }

    private static int findKthLargestMorrisTraversal(BTNode root, int k) {
        return -1;
    }

    public static void main(String[] args) {
        /**
         * Binary Search Tree:
         *            10
         *            /\
         *          5   15
         *         /\   /\
         *        2  5 13 22
         *       /      \
         *      1        14
         * */

        BTNode tree = new BTNode(10);
        tree.left = new BTNode(5);
        tree.right = new BTNode(15);
        tree.left.left = new BTNode(2);
        tree.left.right = new BTNode(5);
        tree.left.left.left = new BTNode(1);
        tree.right.left = new BTNode(13);
        tree.right.right = new BTNode(22);
        tree.right.left.right = new BTNode(14);

        findKthLargestElement(tree, 3);
        findKthLargestElement(tree, 5);
        findKthLargestElement(tree, 8);

        System.out.println("Iterative Approach: " + findKthLargestElementIterative(tree, 3));
        System.out.println("Iterative Approach: " + findKthLargestElementIterative(tree, 5));
        System.out.println("Iterative Approach: " + findKthLargestElementIterative(tree, 8));

        System.out.println("Morris Traversal: " + findKthLargestMorrisTraversal(tree, 3));
        System.out.println("Morris Traversal: " + findKthLargestMorrisTraversal(tree, 5));
        System.out.println("Morris Traversal: " + findKthLargestMorrisTraversal(tree, 8));
    }
}
