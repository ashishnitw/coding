package algorithms.recursion;

public class PrintReversedLinkedList {

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printReverse(Node node) {
        if(node == null) {
            return;
        }
        printReverse(node.next);
        System.out.print(node.data + " -> ");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        printReverse(head);
    }
}
