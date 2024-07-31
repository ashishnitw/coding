package datastructures.linkedlist.problems;

import datastructures.linkedlist.implementation.LinkedList;
import datastructures.linkedlist.implementation.LinkedList.LLNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicatesLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();
        ll.insertAtEnd(1);
        ll.insertAtEnd(2);
        ll.insertAtEnd(2);
        ll.insertAtEnd(3);
        ll.insertAtEnd(3);
        ll.insertAtEnd(4);
        ll.printList();

        //removeDuplicates(ll.head);
        removeDuplicatesUsingMap(ll.head);

        ll.printList();
    }

    // Time complexity: O(n^2)
    // Space complexity: O(1)
    private static void removeDuplicates(LLNode head) {
        LLNode curr = head;
        while (curr != null) {
            LLNode temp = curr;
            while (temp != null && temp.data == curr.data) {
                temp = temp.next;
            }
            curr.next = temp;
            curr = curr.next;
        }
    }

    // Time complexity: O(n)
    // Space complexity: O(n)
    private static void removeDuplicatesUsingMap(LLNode head) {
        Set<Integer> set = new HashSet<>();
        LLNode curr = head;
        LLNode prev = null;
        while (curr != null) {
            if (set.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }
}
