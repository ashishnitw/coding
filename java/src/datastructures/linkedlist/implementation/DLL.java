package datastructures.linkedlist.implementation;

public class DLL {
    static class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int data) {
            this.data = data;
        }
    }

    public static void printList(DLLNode head) {
        DLLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLLNode head = new DLLNode(1);
        DLLNode second = new DLLNode(2);
        DLLNode third = new DLLNode(3);
        DLLNode fourth = new DLLNode(4);

        head.next = second;
        second.prev = head;
        second.next = third;
        third.prev = second;
        third.next = fourth;
        fourth.prev = third;

        printList(head);
    }
}
