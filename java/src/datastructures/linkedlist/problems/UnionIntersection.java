package datastructures.linkedlist.problems;

import datastructures.linkedlist.implementation.LinkedList.LLNode;

import java.util.HashMap;
import java.util.Map;

public class UnionIntersection {

    public static LLNode union(LLNode head1, LLNode head2) {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;
        Map<Integer, Integer> map = new HashMap<>();
        LLNode res = head1;
        LLNode curr = head1;
        while (curr != null) {
            map.put(curr.data, 1);
            curr = curr.next;
        }
        // TODO
        return res;
    }

    public static LLNode intersection(LLNode head1, LLNode head2) {
        if (head1 == null || head2 == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        LLNode res = null;
        // TODO
        return res;
    }

    public static void main(String[] args) {
        // Write your code here
    }
}
