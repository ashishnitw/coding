package datastructures.queue.implementation;

import java.util.Stack;

/**
 * Using one stack and function call stack
 * */
public class QueueUsingOneStack {
    Stack<Integer> stack;

    public QueueUsingOneStack() {
        stack = new Stack<>();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // O(1)
    public void enQueue(int item) {
        System.out.println("Enqueue: " + item);
        stack.push(item);
    }

    // O(n)
    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        if (stack.size() == 1) {
            return stack.pop();
        }
        int item = stack.pop();
        int res = deQueue();    // recursive call
        stack.push(item);
        return res;
    }

    public static void main(String[] args) {
        QueueUsingOneStack queue = new QueueUsingOneStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
    }
}
