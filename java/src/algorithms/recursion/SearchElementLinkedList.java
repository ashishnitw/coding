package algorithms.recursion;

public class SearchElementLinkedList {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static boolean searchElement(Node head, int i) {
        if(head == null) {
            return false;
        }
        if(head.data == i) {
            return true;
        }
        return searchElement(head.next, i);
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(6);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(5);

        System.out.println("Element found: " + searchElement(head, 6));
        System.out.println("Element found: " + searchElement(head, 4));
    }
}
