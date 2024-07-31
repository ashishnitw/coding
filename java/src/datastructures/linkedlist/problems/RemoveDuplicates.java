package datastructures.linkedlist.problems;

import datastructures.linkedlist.implementation.LinkedList;
import datastructures.linkedlist.implementation.LinkedList.LLNode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

    private static void removeDuplicates(LinkedList list) {
        Map<Integer, Integer> map = new HashMap<>();
        LLNode curr = list.head;
        LLNode prev = null;
        while (curr != null) {
            if (map.containsKey(curr.data)) {
                prev.next = curr.next;
            } else {
                map.put(curr.data, 1);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtEnd(8);
        list.insertAtEnd(9);
        list.insertAtEnd(5);

        list.printList();
        removeDuplicates(list);
        list.printList();
    }
}
