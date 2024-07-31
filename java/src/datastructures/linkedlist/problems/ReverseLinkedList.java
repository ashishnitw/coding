package datastructures.linkedlist.problems;

public class ReverseLinkedList {
    static class LLNode {
        int data;
        LLNode next;

        LLNode(int data) {
            this.data = data;
        }
    }

    public static void printList(LLNode head) {
        LLNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    private static LLNode reverseList(LLNode head) {
        LLNode prev = null;
        LLNode curr = head;
        LLNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        LLNode head = new LLNode(1);
        LLNode second = new LLNode(2);
        LLNode third = new LLNode(3);
        LLNode fourth = new LLNode(4);
        LLNode fifth = new LLNode(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        printList(head);
        LLNode reversedHead = reverseList(head);
        printList(reversedHead);
    }
}
