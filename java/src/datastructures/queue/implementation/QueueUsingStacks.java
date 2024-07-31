package datastructures.queue.implementation;

import java.util.Stack;

/**
 * Making dequeue operation costly
 * */
public class QueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public QueueUsingStacks() {
        stack1 = new Stack<>(); // for enQueue
        stack2 = new Stack<>(); // for deQueue
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // O(1)
    public void enQueue(int item) {
        System.out.println("Enqueue: " + item);
        stack1.push(item);
    }

    // O(n)
    public Integer deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println("Stack 1 : " + stack1);
        System.out.println("Stack 2 : " + stack2);
        return stack2.pop();
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        if (stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
        System.out.println("Dequeue: " + queue.deQueue());
    }
}
