package datastructures.linkedlist.problems;

import datastructures.linkedlist.implementation.LinkedList;
import datastructures.linkedlist.implementation.LinkedList.LLNode;

public class KthElementFromEnd {

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.insertAtEnd(5);

        ll.printList();
        System.out.println(nthElementFromEnd(ll.head, 2));
        System.out.println(nthElementFromEnd(ll.head, 3));
        System.out.println(nthElementFromEnd(ll.head, 6));
    }

    private static Integer nthElementFromEnd(LLNode head, int k) {
        LLNode curr = head;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                System.out.println("Invalid value of k: " + k);
                return null;
            }
            curr = curr.next;
        }
        while (curr != null) {
            head = head.next;
            curr = curr.next;
        }
        return head.data;
    }
}
