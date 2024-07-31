package datastructures.queue.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReversingFirstKElementsOfQueue {

    private static void reverseFirstKElements(Queue<Integer> queue, int k) {
        int n = queue.size();
        Stack<Integer> stack = new Stack<>();
        if (queue.isEmpty() || k > queue.size()) {
            return;
        }
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        for (int i=0; i<n-k; i++) {
            queue.add(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int k = 3;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i : arr) {
            queue.add(i);
        }
        System.out.println("Original queue: " + queue);
        reverseFirstKElements(queue, k);
        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}
