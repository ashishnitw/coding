package datastructures.tree.binarytree.check;

import datastructures.tree.binarytree.implementation.BTNode;

public class CheckCousinNodes {

    public static void main(String[] args) {
        /**
         *
         * */

        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);

        System.out.println(areCousins(root, 4, 5));
    }

    private static boolean areCousins(BTNode root, int a, int b) {
        return true;
    }
}
