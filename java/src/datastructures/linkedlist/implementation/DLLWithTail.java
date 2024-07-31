package datastructures.linkedlist.implementation;

public class DLLWithTail {
    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data) {
            this.data = data;
        }
    }

    private DLLNode head;
    private DLLNode tail;

    public void insertAtHead(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void insertAtEnd(int data) {
        DLLNode newNode = new DLLNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void deleteAtHead() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void deleteAtEnd() {
        if (head == null) {
            return;
        }
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void printList() {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLLWithTail dll = new DLLWithTail();

        dll.insertAtEnd(1);
        dll.insertAtEnd(2);
        dll.insertAtEnd(3);
        dll.insertAtEnd(4);
        dll.insertAtHead(5);
        dll.printList();

        dll.deleteAtEnd();
        dll.printList();

        dll.deleteAtHead();
        dll.printList();
    }
}
