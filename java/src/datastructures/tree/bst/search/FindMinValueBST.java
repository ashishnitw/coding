package datastructures.tree.bst.search;


import datastructures.tree.binarytree.implementation.BTNode;

public class FindMinValueBST {

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(15);
        root.left.left = new BTNode(3);
        root.left.right = new BTNode(7);
        root.right.left = new BTNode(12);
        root.right.right = new BTNode(18);
        System.out.println(findMinValueBST(root));
        System.out.println(findMinValueBSTRecursive(root));
    }

    private static Integer findMinValueBST(BTNode root) {
        if (root == null)
            return null;
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }

    private static Integer findMinValueBSTRecursive(BTNode root) {
        if (root == null)
            return null;
        if (root.left == null)
            return root.data;
        return findMinValueBSTRecursive(root.left);
    }
}
