package datastructures.linkedlist.problems;

public class ReverseNodesInKGroup {

    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void addNode(Node head, int data) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1)
            return head;
        Node prev = null;
        Node curr = head;
        Node next = null;

        // TODO

        return null;
    }

    public static void main(String[] args) {

        // Create a linked list
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        Node head = new Node(1);
        addNode(head, 2);
        addNode(head, 3);
        addNode(head, 4);
        addNode(head, 5);
        addNode(head, 6);
        printList(head);

        head = reverseKGroup(head, 3);
        printList(head);
    }
}
