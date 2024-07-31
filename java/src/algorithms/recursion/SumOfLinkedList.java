package algorithms.recursion;

public class SumOfLinkedList {

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int sum(Node head) {
        if(head == null) {
            return 0;
        }
        return head.data + sum(head.next);
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(5);

        System.out.println("Sum of linked list: " + sum(head));
    }
}
