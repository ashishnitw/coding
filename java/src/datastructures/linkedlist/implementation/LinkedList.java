package datastructures.linkedlist.implementation;

public class LinkedList {

    public static class LLNode {
        public int data;
        public LLNode next;

        public LLNode(int data) {
            this.data = data;
        }
    }

    public LLNode head;

    public LinkedList() {
        this.head = null;
    }

    public void printList() {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Time complexity: O(1)
    public void insertAtHead(int data) {
        LLNode newNode = new LLNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Time complexity: O(n)
    public void insertAtEnd(int data) {
        LLNode newNode = new LLNode(data);
        if (head == null) {
            head = newNode;
        } else {
            LLNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void deleteAtHead() {
        if (head == null)
            return;
        head = head.next;
    }

    public void deleteByValue(int value) {
        if (head == null)
            return;
        LLNode curr = head;
        LLNode prev = null;
        if (curr.data == value) {
            head = head.next;
            curr.next = null;
            return;
        }
        while (curr != null) {
            if (curr.data == value) {
                prev.next = curr.next;
                curr.next = null;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtHead(5);
        ll.insertAtHead(6);
        ll.printList();

        ll.deleteAtHead();
        ll.printList();

        ll.deleteByValue(3);
        ll.printList();

        ll.deleteByValue(5);
        ll.printList();

    }
}
