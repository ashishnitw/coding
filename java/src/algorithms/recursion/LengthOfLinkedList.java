package algorithms.recursion;

public class LengthOfLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static int length(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + length(head.next);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Length of linked list: " + length(head));

        head.next.next.next = new Node(4);
        System.out.println("Length of linked list: " + length(head));

        head.next.next.next.next = new Node(5);
        System.out.println("Length of linked list: " + length(head));
    }
}
